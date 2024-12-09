package com.veritabaniproje.backend.repository;

import com.veritabaniproje.backend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Bir kullanıcıya gelen mesajları bulur
    List<Message> findByReceiverId(Long receiverId);

    // Bir kullanıcıdan gönderilen mesajları bulur
    List<Message> findBySenderId(Long senderId);

    // Belirli bir gönderici ve alıcı arasında geçen mesajları bulur
    List<Message> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
