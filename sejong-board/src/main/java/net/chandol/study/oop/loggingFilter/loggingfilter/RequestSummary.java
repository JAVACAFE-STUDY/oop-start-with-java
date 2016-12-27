package net.chandol.study.oop.loggingFilter.loggingfilter;

public class RequestSummary {
    private String host;
    private String url;
    private String method;
    private String body;
    private String userId;

    public RequestSummary(String host, String method, String url, String body, String userId) {
        this.host = host;
        this.url = url;
        this.method = method;
        this.body = body;
        this.userId = userId;
    }

    public String getHost() {
        return host;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }


    public String getUserId() {
        return userId;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "RequestSummary{" +
                "host='" + host + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", body='" + body + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
