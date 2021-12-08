package fr.lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatMessageController {
    ChatMessageListener repository;

    public ChatMessageController(ChatMessageListener listener) {
        repository = listener;
    }

    @GetMapping("/api/message")
    public List<String> getChatMessages() {
        return repository.repo.getLastTenMessages();
    }
}
