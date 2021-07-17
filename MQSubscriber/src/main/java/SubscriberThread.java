import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SubscriberThread extends Thread {

    private final String tag;

    public SubscriberThread(String tag) {
        this.tag = tag;
    }

    @Override
    public void run() {
        Subscriber subscriber = new Subscriber();

        try {
            subscriber.read(tag);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
