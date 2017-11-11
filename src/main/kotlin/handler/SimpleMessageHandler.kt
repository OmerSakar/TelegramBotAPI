package handler

import update.Update

class SimpleMessageHandler: TelegramMessageHandler() {

    override fun handleMessage(update: Update) =
            sendMessage(update.message!!.chat.id,
                    update.message!!.text!!,
                    reply_to_message_id = update.message!!.messageId)
}