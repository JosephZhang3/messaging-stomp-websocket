package pers.zebulon.ws.web;

import pers.zebulon.ws.model.Notify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledNotify {

//    private Logger logger = LoggerFactory.getLogger(ScheduledNotify.class);
//
//    private final SimpMessagingTemplate simpMessagingTemplate;
//
//    @Autowired
//    public ScheduledNotify(SimpMessagingTemplate simpMessagingTemplate) {
//        this.simpMessagingTemplate = simpMessagingTemplate;
//    }
//
//    /**
//     * 项目启动后，每隔10秒给 client 回传一条通知 json
//     */
//    @Scheduled(fixedRate = 5000)
//    private void produceNotify() {
//        Date now = new Date();
//        logger.info("Date is {}", now.toString());
//        simpMessagingTemplate.convertAndSend("/topic/notify", new Notify("标题", "内容", now));
//    }
}
