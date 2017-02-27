import com.google.api.client.http.*;

import java.io.IOException;
import java.util.List;

public class TelegramUpdates {

    private int offset = 0;
    private String updateUrl = "/getUpdates";
    private TelegramMessageHandler handler = new SimpleMessageHandler();
    private int timeout = 100;

    public void getUpdates() {
        getUpdates(this.offset, 100, this.timeout);
    }

    public void getUpdates(Integer offset, Integer limit, Integer timeout) {
        offset++;
        HttpRequestFactory requestFactory = Variables.getHttpRequestFactory();
        try {
            String requestBody = new StringBuilder().append("{\"offset\":" + offset + "}").toString();
            HttpRequest request = requestFactory.buildPostRequest(new TelegramUrl(Variables.getBaseUrl() + updateUrl),
                    ByteArrayContent.fromString("application/json", requestBody));
            Updates updates = request.execute().parseAs(Updates.class);
            List<Updates.Update> updateList = updates.getResult();
            updateList.sort((u1, u2) -> Integer.compare(u1.getUpdate_id(), u2.getUpdate_id()));
            if(!updateList.isEmpty()) this.offset = updateList.get(0).getUpdate_id();
            System.out.println(updateList.size());
            updates.getResult().forEach(update -> this.handler.handleMessage(update)) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) throws InterruptedException, IOException {
        TelegramUpdates t = new TelegramUpdates();
        t.handler.getMe();
        while (true) {
            t.getUpdates();
            Thread.sleep(1000);
            System.out.println("updated");
        }
    }

}
