package net.chandol.study.oop.loggingFilter.loggingfilter;



import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static net.chandol.study.oop.loggingFilter.loggingfilter.HttpReadUtils.getHttpBody;

@Component
public class RequestLoggingFilter implements Filter {

    private static final String DEFAULT_ENCODING = "UTF-8";

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ReusableHttpServletRequest reusableRequest = new ReusableHttpServletRequest(httpRequest);

        String encoding = "UTF-8";


        RequestSummary requestSummary = new RequestSummary(
                reusableRequest.getRemoteHost(),
                reusableRequest.getMethod(),
                HttpReadUtils.getRequestURLWithQueryString(reusableRequest),
                getHttpBody(reusableRequest, encoding),
                null);

        System.out.println(requestSummary);
        chain.doFilter(reusableRequest, response);
    }

    @Override
    public void destroy() {
        // do nothing
    }

}