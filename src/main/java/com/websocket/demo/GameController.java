package com.websocket.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    @MessageMapping("/move")
    @SendTo("/topic/game")
    public String handleMove(String move) {
        System.out.println("Message from client: "+ move);
        // Process the move and return the updated game state
        return "Player Moved from Server!";
    }
}