package br.com.touros.punterbot.api.integracao.hotmart;

public class HotmartConstants {

    public static final String URL_SECURITY = "https://api-sec-vlc.hotmart.com/security/";
    public static final String URL_API_HOT = "https://api-hot-connect.hotmart.com/";

    public static class Uri {
        public static final String GET_TOKEN = "oauth/token";
    }

    public static class Header {
        public static final String AUTH = "Authorization";
    }

    public static class Parameter {
        public static final String GRANT_TYPE = "grant_type";
        public static final String CLIENT_ID = "client_id";
        public static final String CLIENT_SECRET = "client_secret";
    }
}
