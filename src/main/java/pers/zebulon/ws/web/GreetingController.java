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
     * 浏览器对我（服务端）说hello，我（服务端）就表示欢迎
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting handleHello(HelloMessage helloMessage) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Tid is " + Thread.currentThread().getId());
        System.out.println("Tid name " + Thread.currentThread().getName());
        return new Greeting("Yeap,how about you ? " + HtmlUtils.htmlEscape(helloMessage.getName()) + ".");
    }

}
