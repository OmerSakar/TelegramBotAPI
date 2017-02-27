public class SimpleMessageHandler extends TelegramMessageHandler {

    @Override
    public void handleMessage(Updates.Update update) {
        sendMessage(update.getMessage().getChat().getId(), update.getMessage().getText(), update.getMessage().getMessage_id());
    }


}
