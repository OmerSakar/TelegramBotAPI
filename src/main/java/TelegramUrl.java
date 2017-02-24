import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

/**
 * Created by omer on 20-11-16.
 */
public class TelegramUrl extends GenericUrl {

    public TelegramUrl(String encodedUrl) {
        super(encodedUrl);
    }

    @Key
    public String fields;
}
