package net.chandol.study.oop.loggingFilter.loggingfilter;

import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * HTTP 서블릿의 body 부분을 두 번 이상 읽을 수 없기 때문에 사용함.
 * http://stackoverflow.com/questions/1046721/accessing-the-raw-body-of-a-put-or-post-request
 */
public class ReusableHttpServletRequest extends HttpServletRequestWrapper {

    public static final String DEFAULT_ENCODING = "UTF-8";

    private byte[] body;

    public ReusableHttpServletRequest(HttpServletRequest httpServletRequest) throws IOException {
        super(httpServletRequest);
        // Read the request body and save it as a byte array
        InputStream is = super.getInputStream();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        StreamUtils.copy(is, output);

        body = output.toByteArray();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new ServletInputStreamImpl(new ByteArrayInputStream(body));
    }

    @Override
    public BufferedReader getReader() throws IOException {
        String enc = getCharacterEncoding();
        return new BufferedReader(new InputStreamReader(getInputStream(), enc));
    }

    private static class ServletInputStreamImpl extends ServletInputStream {

        private InputStream is;

        public ServletInputStreamImpl(InputStream is) {
            this.is = is;
        }

        public int read() throws IOException {
            return is.read();
        }

        public boolean markSupported() {
            return false;
        }

        public synchronized void mark(int i) {
            throw new RuntimeException(new IOException("mark/reset not supported"));
        }

        public synchronized void reset() throws IOException {
            throw new IOException("mark/reset not supported");
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener listener) {

        }
    }

}