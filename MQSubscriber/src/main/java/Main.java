import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        for (int i = 1; i <= 100; i++) {
            Thread thread = new SubscriberThread("THREAD_" + i);
            thread.run();
        }

//        Thread thread1 = new SubscriberThread("THREAD_1");
//        thread1.run();
//
//        Thread thread2 = new SubscriberThread("THREAD_2");
//        thread2.run();
//
//        Thread thread3 = new SubscriberThread("THREAD_3");
//        thread3.run();
    }
}
