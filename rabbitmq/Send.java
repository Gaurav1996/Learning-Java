package examples.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 1) Download maven dependency for RMQ for Java
 * 2) i)Start the rabbit mq server locally [Use brew to install rabbit mq] using 'rabbitmq-server'
 *                   (or)
 *    ii) You can point to the cloud instance created at cloudamqp and get the instance details and set in the code accordingly
 * 3) Play around by running Send and then running Recv (or) use the cloud web interface [Either localhost:15672 if 2 i) or cloudmq web interfcae if 2 ii)]
 * to publish messages to Queue or channel
 */
public class Send {
    public static void main(String[]args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("");
        factory.setVirtualHost("");
        //factory.setPort(1883);
        factory.setUsername("");
        factory.setPassword("");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String message = "Hi Gaurav!";
        channel.queueDeclare(Utils.QUEUE_NAME, false, false, false, null);

        channel.basicPublish("", Utils.QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
