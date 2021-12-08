package fr.lernejo.chat;

import java.util.ArrayList;
import java.util.List;

public class ChatMessageRepository {
    List<String> messages = new ArrayList<>();



    void addChatMessage(String message){
        messages.add(message);
    }

    List<String> getLastTenMessages(){
        if(messages.size()>10)
            return messages.subList( messages.size() - 10, messages.size());
        else
            return messages;
    }
}
