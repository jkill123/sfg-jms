package pinchuk.sfgjms.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import pinchuk.sfgjms.config.JmsConfig;
import pinchuk.sfgjms.model.HelloWorldMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

/**
 * @author Pinchuk Yevhen
 * @created 20/03/2020 - 18:40
 */
@RequiredArgsConstructor
@Component
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    private void listen(@Payload HelloWorldMessage helloWorldMessage,
                        @Headers MessageHeaders headers, Message message){

//        System.out.println("I got message");
//        System.out.println(helloWorldMessage);
    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    private void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                        @Headers MessageHeaders headers, Message message) throws JMSException {

        HelloWorldMessage payloadMsg = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("World")
                .build();

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMsg);
    }
}