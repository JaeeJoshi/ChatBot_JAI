package com.example.JAI3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JAI3.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long>{

     List<Chat> findByUsername(String username);

}
