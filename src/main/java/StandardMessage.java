import com.google.api.client.util.Key;

/**
 * Created by omer on 20-11-16.
 */
public class StandardMessage<T> {

    @Key
    public boolean ok;

    @Key
    public T result;

}
