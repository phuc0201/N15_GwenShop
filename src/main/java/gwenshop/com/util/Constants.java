package gwenshop.com.util;

public class Constants {
    public static final String SESSION_USERNAME = "username"; //use for session
    public static final String COOKIE_REMEMBER = "username"; //or use for cookie

    //Google get api
    public static String GOOGLE_CLIENT_ID = "113142238636-9ddk69kacndb9d01qd4lhludckl5o343.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "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";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/GwenShop_war_exploded/login-google";
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";

    //Facebook get api
    public static String FACEBOOK_APP_ID = "1866396290374836";
    public static String FACEBOOK_APP_SECRET = "cc2764bdcfcd0ca4f7f51d6266076ce2";
    public static String FACEBOOK_REDIRECT_URL = "https://localhost:8080/GwenShop_war_exploded/login-facebook";
    public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
}
