package net.chandol.study.oop.loggingFilter.loggingfilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class HttpReadUtils {

    private static Logger log = LoggerFactory.getLogger(HttpReadUtils.class);

    private final static String APPLICATION_FORM_URLENCODED_VALUE = "application/x-www-form-urlencoded";

    @SuppressWarnings("serial")
    private static final Set<String> MULTI_READ_HTTP_METHODS = new HashSet<String>() {{
        add("PUT");
        add("POST");
    }};


    public static String getHttpBody(HttpServletRequest request, String encoding) {
        if (!isReadableHttpBody(request.getMethod())) return null;
        if (isFormUrlencoded(request)) return readParameters(request);

        if (!(request instanceof ReusableHttpServletRequest)) {
            if (log.isWarnEnabled()) {
                log.warn("ReusableHttpServletRequest 타입이 아닙니다. requestType={} URL={}", request.getClass(), getRequestURLWithQueryString(request));
            }
            return null;
        }

        return readBody(request, encoding);
    }


    public static boolean isReadableHttpBody(String method) {
        return MULTI_READ_HTTP_METHODS.contains(method);
    }

    private static boolean isFormUrlencoded(HttpServletRequest request) {
        return request.getContentType() != null && request.getContentType().contains(APPLICATION_FORM_URLENCODED_VALUE);
    }


    private static String readParameters(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String[]>> iterator = request.getParameterMap().entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String[]> entry = iterator.next();

            String[] value = entry.getValue();
            for (int i = 0; i < value.length; i++) {
                sb.append(entry.getKey()).append("=").append(value[i]);
                if (i < value.length - 1) {
                    sb.append("&");
                }
            }

            if (iterator.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    static String getRequestURLWithQueryString(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder(128);

        sb.append(request.getRequestURL());
        if (null != request.getQueryString()) {
            sb.append("?");
            sb.append(request.getQueryString());
        }
        return sb.toString();
    }

    private static String readBody(HttpServletRequest request, String encoding) {
        try {
            if (request.getInputStream() == null) return null;
            return StreamUtils.copyToString(request.getInputStream(), Charset.forName(encoding));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}