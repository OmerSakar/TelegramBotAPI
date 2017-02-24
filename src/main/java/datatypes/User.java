package datatypes;

import com.google.api.client.util.Key;
import lombok.ToString;

/**
 * Created by omer on 17-7-16.
 */
@ToString
public class User {

    @Key private int id;
    @Key private String first_name;
    @Key private String last_name;
    @Key private String username;
}
