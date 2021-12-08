package fr.lernejo.chat;

import org.springframework.stereotype.Component;

@Component

public class ChatMessageListener {

    ChatMessageRepository repo=new ChatMessageRepository();

    public void onMessage (String message){
        repo.addChatMessage(message);
        System.out.println(message);
    }
}

