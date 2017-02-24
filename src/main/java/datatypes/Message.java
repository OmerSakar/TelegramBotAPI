package datatypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.Key;
import datatypes.not_implemented.*;
import lombok.Data;


import java.util.Arrays;

/**
 * Created by omer on 30-6-16.
 */
@Data
public class Message {

    @Key private int message_id;
    @Key private User from;
    @Key private int date;
    @Key private Chat chat;
    @Key private User forward_from;
    @Key private Chat forward_from_chat;
    @Key private int forward_date;
    @Key private Message reply_to_message;
    @Key private int edit_date;
    @Key private String text;
    @Key private MessageEntity[] entities;
    @Key private Audio audio;
    @Key private Document document;
    @Key private PhotoSize[] photo;
    @Key private Sticker sticker;
    @Key private Video video;
    @Key private Voice voice;
    @Key private String caption;
    @Key private Contact contact;
    @Key private Location location;
    @Key private Venue venue;
    @Key private User new_char_member;
    @Key private User left_chat_member;
    @Key private String new_char_title;
    @Key private PhotoSize[] new_chat_photo;
    @Key private boolean delete_chat_photo;
    @Key private boolean group_chat_created;
    @Key private boolean supergroup_chat_created;
    @Key private boolean channel_chat_created;
    @Key private int migrate_to_chat_id;
    @Key private int migrate_from_chat_id;
    @Key private Message pinned_message;

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", forward_from=" + forward_from +
                ", forward_from_chat=" + forward_from_chat +
                ", forward_date=" + forward_date +
                ", reply_to_message=" + reply_to_message +
                ", edit_date=" + edit_date +
                ", text='" + text + '\'' +
                ", entities=" + Arrays.toString(entities) +
                ", audio=" + audio +
                ", document=" + document +
                ", photo=" + Arrays.toString(photo) +
                ", sticker=" + sticker +
                ", video=" + video +
                ", voice=" + voice +
                ", caption='" + caption + '\'' +
                ", contact=" + contact +
                ", location=" + location +
                ", venue=" + venue +
                ", new_char_member=" + new_char_member +
                ", left_chat_member=" + left_chat_member +
                ", new_char_title='" + new_char_title + '\'' +
                ", new_chat_photo=" + Arrays.toString(new_chat_photo) +
                ", delete_chat_photo=" + delete_chat_photo +
                ", group_chat_created=" + group_chat_created +
                ", supergroup_chat_created=" + supergroup_chat_created +
                ", channel_chat_created=" + channel_chat_created +
                ", migrate_to_chat_id=" + migrate_to_chat_id +
                ", migrate_from_chat_id=" + migrate_from_chat_id +
                ", pinned_message=" + pinned_message +
                "]\n";
    }

    public static void main(String... args) throws JsonProcessingException {
            Message dto = new Message();
            dto.setMessage_id(2);

            String serialized = new ObjectMapper().writeValueAsString(dto);

            System.out.println(serialized);
    }
}
