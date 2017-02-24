package datatypes;

import com.google.api.client.util.Key;
import lombok.Data;
import lombok.ToString;

@Data
public class Chat {

    @Key private int id;
    @Key private String type;
    @Key private String title;
    @Key private String username;
    @Key private String first_name;
    @Key private String last_name;
}
