import com.google.api.client.util.Key;
import datatypes.not_implemented.CallbackQuery;
import datatypes.not_implemented.ChosenInlineResult;
import datatypes.not_implemented.InlineQuery;
import datatypes.Message;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * Created by omer on 20-11-16.
 */
@ToString
public class Updates {

    @Key
    private boolean ok;

    @Key
    @Getter
    private List<Update> result;

    @Data
    public static class Update {
        @Key
        private Integer update_id;

        @Key
        private Message message;

        @Key
        private Message edited_message;

        @Key
        private InlineQuery inline_query;

        @Key
        private ChosenInlineResult chosen_inline_result;

        @Key
        private CallbackQuery callback_query;
    }

}
