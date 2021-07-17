import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class Subscriber {

    private static final String QUEUE_NAME = "hello";

    public void read(String tag) throws IOException, TimeoutException, InterruptedException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(tag + ": " + message);

            Random random = new Random();
            int sleep = random.nextInt(10) * 1000;

            System.out.println(sleep);

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});


    }
}
