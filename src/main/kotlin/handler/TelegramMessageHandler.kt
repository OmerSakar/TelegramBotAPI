package handler

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode
import com.google.api.client.http.ByteArrayContent
import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpRequestFactory
import datatypes.Message
import datatypes.User
import update.StandardMessage
import update.TelegramUrl
import update.Update
import update.Variables
import java.io.IOException

abstract class TelegramMessageHandler {

    abstract fun handleMessage(update: Update)

    fun sendMessage(chat_id: Int,
                    text: String,
                    parse_mode: String? = null,
                    disable_web_page_preview: Boolean? = null,
                    disable_notification: Boolean? = null,
                    reply_to_message_id: Int? = null,
                    reply_markup: String? = null) {

        val requestFactory: HttpRequestFactory = Variables.httpRequestFactory

        val node: ObjectNode = JsonNodeFactory.instance.objectNode()

        node.put("chat_id", chat_id)
        node.put("text", text)
        if (disable_web_page_preview != null) node.put("disable_web_page_preview", disable_web_page_preview)
        if (reply_to_message_id != null) node.put("reply_to_message_id", reply_to_message_id)
        if (disable_notification != null) node.put("disable_notification", disable_notification)
        if (reply_markup != null) node.put("reply_markup", reply_markup)


        try {
            val request = requestFactory.buildPostRequest(TelegramUrl(Variables.baseUrl + "/sendMessage"),
                    ByteArrayContent.fromString("application/json", node.toString()))
            request.headers.contentType = "application/json"
            request.requestMethod = "POST"

            val (ok, result) = request.execute().parseAs(StandardMessage::class.java)
            if (!ok) System.err.println("bad request\t" + result!!)
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }


    fun getMe(): User = TODO()

//        val requestFactory: HttpRequestFactory = Variables.httpRequestFactory;
//        val url: TelegramUrl = TelegramUrl(Variables.baseUrl + "/getMe");
//        val request: HttpRequest = requestFactory.buildGetRequest(url);
//        val json = request.execute().content
//        val stdMessage: StandardMessage<User> = JsonParser.
//
////        val (ok, result) = request.execute().parseAs(StandardMessage::class.java)
//
//        if (!ok) System.err.println("bad request\t" + result!!)
//
//        return ;
//    }
    fun forwardMessage(): Message = TODO()

}

