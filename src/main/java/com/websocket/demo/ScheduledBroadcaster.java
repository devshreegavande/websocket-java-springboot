package com.websocket.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledBroadcaster {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Scheduled(initialDelay = 300000) // 5 minutes in milliseconds
    public void scheduledBroadcast() {
        String message = "This is a scheduled broadcast message";
        System.out.println("Server broadcastinbg ... " + message);
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
