package xyz.sydns.me.rabbitmq.main.example2;


import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 *
 * @todo
 * @test
 * import org.apache.commons.lang.SerializationUtils;
 * import org.apache.commons.lang3.SerializationUtils;
 * import org.springframework.amqp.utils.SerializationUtils;
 * import org.springframework.util.SerializationUtils;
 *
 * @author sqsgalaxys
 */
public class Sender extends BaseConnector {
    public Sender(String queueName) throws IOException, TimeoutException {
        super(queueName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("", queueName, null, SerializationUtils.serialize(object));
    }
}