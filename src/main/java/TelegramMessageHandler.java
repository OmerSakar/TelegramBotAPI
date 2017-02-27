import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.api.client.http.*;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.ArrayMap;
import datatypes.Chat;
import datatypes.Message;
import datatypes.TelegramBotApi;
import datatypes.User;

import javax.jws.soap.SOAPBinding;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

/**
 * Created by omer on 20-11-16.
 */
public abstract class TelegramMessageHandler {
    abstract void handleMessage(Updates.Update update);

    //TODO reply_markup needs to be another type, this will be done after the specific types are
    public void sendMessage(int chat_id, String text, String parse_mode, Boolean disable_web_page_preview,
                            Boolean disable_notification, Integer reply_to_message_id, String reply_markup) {
        HttpRequestFactory requestFactory = Variables.getHttpRequestFactory();

        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("chat_id", chat_id);
        node.put("text", text);
        if (disable_web_page_preview != null) node.put("disable_web_page_preview", disable_web_page_preview);
        if (reply_to_message_id != null) node.put("reply_to_message_id", reply_to_message_id);
        if (disable_notification != null) node.put("disable_notification", disable_notification);
        if (reply_markup != null) node.put("reply_markup", reply_markup);

        try {
            HttpRequest request = requestFactory.buildPostRequest(new TelegramUrl(Variables.getBaseUrl() + "/sendMessage"),
                    ByteArrayContent.fromString("application/json", node.toString()));
            request.getHeaders().setContentType("application/json");
            request.setRequestMethod("POST");

            StandardMessage standardMessage = request.execute().parseAs(StandardMessage.class);
            if(!standardMessage.ok) System.err.println("bad request\t" + standardMessage.result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(int chat_id, String text, int reply_to_message_id) {
        this.sendMessage(chat_id, text, null, null, null,
                reply_to_message_id, null);
    }

    public void sendMessage(int chat_id, String text) {
        this.sendMessage(chat_id, text, null, null, null,
                null, null);
    }

    public User getMe() throws IOException {
        HttpRequestFactory requestFactory = Variables.getHttpRequestFactory();
        TelegramUrl url = new TelegramUrl(Variables.getBaseUrl() + "/getMe");
        HttpRequest request = requestFactory.buildGetRequest(url);
        System.out.println(request.execute().parseAsString());

        return null;
    }


}
