//package handler;
//
//import com.fasterxml.jackson.databind.node.JsonNodeFactory;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.google.api.client.http.*;
//import datatypes.User;
//import update.StandardMessage;
//import update.TelegramUrl;
//import update.Update;
//import update.Variables;
//
//import java.io.IOException;
//
///**
// * Created by omer on 20-11-16.
// */
//public abstract class TelegramMessageHandler {
//    public abstract void handleMessage(Update update);
//
//    //TODO reply_markup needs to be another type, this will be done after the specific types are implemented
//    public void sendMessage(int chat_id, String text, String parse_mode, Boolean disable_web_page_preview,
//                            Boolean disable_notification, Integer reply_to_message_id, String reply_markup) {
//        HttpRequestFactory requestFactory = Variables.INSTANCE.getHttpRequestFactory();
//
//        ObjectNode node = JsonNodeFactory.instance.objectNode();
//        node.put("chat_id", chat_id);
//        node.put("text", text);
//        if (disable_web_page_preview != null) node.put("disable_web_page_preview", disable_web_page_preview);
//        if (reply_to_message_id != null) node.put("reply_to_message_id", reply_to_message_id);
//        if (disable_notification != null) node.put("disable_notification", disable_notification);
//        if (reply_markup != null) node.put("reply_markup", reply_markup);
//
//        try {
//            HttpRequest request = requestFactory.buildPostRequest(new TelegramUrl(Variables.INSTANCE.getBaseUrl() +
//                            "/sendMessage"),
//                    ByteArrayContent.fromString("application/json", node.toString()));
//            request.getHeaders().setContentType("application/json");
//            request.setRequestMethod("POST");
//
//            StandardMessage standardMessage = request.execute().parseAs(StandardMessage.class);
//            if(!standardMessage.getOk()) System.err.println("bad request\t" + standardMessage.getResult());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void sendMessage(int chat_id, String text, int reply_to_message_id) {
//        this.sendMessage(chat_id, text, null, null, null,
//                reply_to_message_id, null);
//    }
//
//    public void sendMessage(int chat_id, String text) {
//        this.sendMessage(chat_id, text, null, null, null,
//                null, null);
//    }
//
//    public User getMe() throws IOException {
//        HttpRequestFactory requestFactory = Variables.INSTANCE.getHttpRequestFactory();
//        TelegramUrl url = new TelegramUrl(Variables.INSTANCE.getBaseUrl() + "/getMe");
//        HttpRequest request = requestFactory.buildGetRequest(url);
//        System.out.println(request.execute().parseAsString());
//
//        return null;
//    }
//
//    public void forwardMessage(int chat_id, int from_chat_id, Boolean disable_notification, int message_id) {
//        HttpRequestFactory requestFactory = Variables.INSTANCE.getHttpRequestFactory();
//
//        ObjectNode node = JsonNodeFactory.instance.objectNode();
//        node.put("chat_id", chat_id);
//        node.put("from_chat_id", from_chat_id);
//        node.put("message_id", message_id);
//        if (disable_notification != null) node.put("disable_notification", disable_notification);
//
//        try {
//            HttpRequest request = requestFactory.buildPostRequest(new TelegramUrl(Variables.INSTANCE.getBaseUrl() +
//                    "/forwardMessage"),
//                    ByteArrayContent.fromString("application/json", node.toString()));
//            request.getHeaders().setContentType("application/json");
//            request.setRequestMethod("POST");
//
//            StandardMessage standardMessage = request.execute().parseAs(StandardMessage.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void forwardMessage(int chat_id, int from_chat_id, int message_id) {
//        forwardMessage(chat_id, from_chat_id, null, message_id);
//    }
//
//
//}
