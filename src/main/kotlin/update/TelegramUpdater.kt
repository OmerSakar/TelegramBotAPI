package update

import com.google.api.client.http.ByteArrayContent
import com.google.api.client.http.HttpRequest
import handler.TelegramMessageHandler
import handler.SimpleMessageHandler
import java.io.IOException

class TelegramUpdater(
        private var offset: Int = 0,
        private val updateUrl: String = "/getUpdates",
        val handler: TelegramMessageHandler = SimpleMessageHandler(),
        val timeout: Int = 100,
        val limit: Int = 100
) {

    fun getUpdates(offset: Int = this.offset, limit: Int = this.limit, timeout: Int = this.timeout) {

        synchronized(offset) {
            val requestFactory = Variables.httpRequestFactory
            try {
                val requestBody = StringBuilder().append("{\"offset\":" + offset + "}").toString()
                val request: HttpRequest = requestFactory.buildPostRequest(
                        TelegramUrl(Variables.baseUrl + updateUrl),
                        ByteArrayContent.fromString("application/json", requestBody))

                val updates: Updates = request.execute().parseAs(Updates::class.java)

                val updateList: List<Update> = updates.result
                updateList.sortedBy { it.updateId }
                if (!updateList.isEmpty()) {
                    this.offset = updateList.last().updateId + 1
                }
                updates.result.forEach({ update -> this.handler.handleMessage(update) })
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}

fun runTelegramBot(token: String, handler: TelegramMessageHandler, timeBetweenPolls: Long = 100) {
    setToken(token)
    val tUpdater = TelegramUpdater(handler = handler)
    while (true) {
        tUpdater.getUpdates()
        Thread.sleep(timeBetweenPolls)
    }
}

fun main(args: Array<String>) {
    runTelegramBot("150287693:AAGJ-J-7-OiNiu8PW9QuKVf1VBvt-MNWt_w",
            SimpleMessageHandler())
}

