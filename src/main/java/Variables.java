import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;

/**
 * Created by omer on 20-11-16.
 */
public class Variables {
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final String TOKEN = "150287693:AAGJ-J-7-OiNiu8PW9QuKVf1VBvt-MNWt_w";
    private static final String BASE_URL = "https://api.telegram.org/bot" + TOKEN;

    public static HttpRequestFactory getHttpRequestFactory() {
        return HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest request) {
                request.setParser(new JsonObjectParser(JSON_FACTORY));
            }
        });
    }

    public static String getToken() {
        return TOKEN;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static JsonFactory getJsonFactory() { return JSON_FACTORY; }

}
