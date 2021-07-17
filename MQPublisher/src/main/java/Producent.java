import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.concurrent.TimeoutException;

public class Producent {

    private static final String QUEUE_NAME = "hello";

    public void send() throws IOException, TimeoutException, InterruptedException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        while (true) {
            String message = new Timestamp(System.currentTimeMillis()) + ": Hello World!";

            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));

            Thread.sleep(1000);
        }
    }
}
