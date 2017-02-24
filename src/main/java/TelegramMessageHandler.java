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

    public void sendMessage(int chat_id, String text, int reply_to_message_id) {
        HttpRequestFactory requestFactory = Variables.getHttpRequestFactory();

        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("chat_id", chat_id);
        node.put("text", text);
        node.put("reply_to_message_id", reply_to_message_id);

        try {
            String requestBody = node.toString();
            HttpRequest request = requestFactory.buildPostRequest(new TelegramUrl(Variables.getBaseUrl() + "/sendMessage"),
                    ByteArrayContent.fromString("application/json", requestBody));
            request.getHeaders().setContentType("application/json");
            request.setRequestMethod("POST");

            StandardMessage videoFeed = request.execute().parseAs(StandardMessage.class);
            if (videoFeed.ok) {
                if (videoFeed.result instanceof ArrayMap){
                    ArrayMap result = (ArrayMap<String, String>) videoFeed.result;
                    assert ((ArrayMap<String, String>) (result.get("chat"))).get("id").equals(new String("" + chat_id));

                } else {
                    System.err.println("Oke something bad happened");
                }
            } else {
                System.err.println("bad request\t" + videoFeed.result);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getMe() throws IOException {
        HttpRequestFactory requestFactory = Variables.getHttpRequestFactory();
        TelegramUrl url = new TelegramUrl(Variables.getBaseUrl() + "/getMe");
        HttpRequest request = requestFactory.buildGetRequest(url);
        System.out.println(request.execute().parseAsString());

        return null;
    }

}
