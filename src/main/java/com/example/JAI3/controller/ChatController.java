package com.example.JAI3.controller;

//import org.apache.el.stream.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JAI3.dto.AskRequest;
import com.example.JAI3.model.Chat;
import com.example.JAI3.model.Message;
import com.example.JAI3.repository.ChatRepository;
import com.example.JAI3.repository.MessageRepository;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/start")
    public Chat startNewChat(Authentication auth){
        Chat chat = new Chat();
        chat.setUsername(auth.getName());
        return chatRepository.save(chat);
    }

    @PostMapping("/ask")
    public String askQuestion(@RequestBody AskRequest request, Authentication auth){
        Optional<Chat> chatOpt = chatRepository.findById(request.chatId);

        if (chatOpt.isEmpty() || !chatOpt.get().getUsername().equals(auth.getName())) {
            return "Invalid chat ID or unauthorized access.";
    }

    
        Chat chat = chatOpt.get();

        Message userMessage = new Message();
        userMessage.setContent(request.question);
        userMessage.setRole("USER");
        userMessage.setChat(chat);
        messageRepository.save(userMessage);

        // Placeholder response
        Message botReply = new Message();
        botReply.setContent("Bot will respond here...");
        botReply.setRole("BOT");
        botReply.setChat(chat);
        messageRepository.save(botReply);

        return "Question submitted successfully.";
    }
    
}
