package com.example.JAI3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JAI3.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
