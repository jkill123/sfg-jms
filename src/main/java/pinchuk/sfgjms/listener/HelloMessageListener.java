package pinchuk.sfgjms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import pinchuk.sfgjms.config.JmsConfig;
import pinchuk.sfgjms.model.HelloWorldMessage;

import javax.jms.Message;

/**
 * @author Pinchuk Yevhen
 * @created 20/03/2020 - 18:40
 */
@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    private void listen(@Payload HelloWorldMessage helloWorldMessage,
                        @Headers MessageHeaders headers, Message message){

        System.out.println("I got message");
        System.out.println(helloWorldMessage);
    }
}