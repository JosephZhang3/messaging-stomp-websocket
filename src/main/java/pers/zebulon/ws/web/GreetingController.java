package pers.zebulon.ws.web;

import pers.zebulon.ws.model.Greeting;
import pers.zebulon.ws.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    /**
     * 浏览器对服务端说hello，服务端表示欢迎
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting handleHello(HelloMessage helloMessage) throws InterruptedException {
        Thread.sleep(3000);
        return new Greeting("I'm fine,how about you ? " + HtmlUtils.htmlEscape(helloMessage.getName()) + ".");
    }

}
