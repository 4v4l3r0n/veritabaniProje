package com.veritabaniproje.backend.bootstrap;

import com.veritabaniproje.backend.model.Advertisement;
import com.veritabaniproje.backend.model.Message;
import com.veritabaniproje.backend.model.Role;
import com.veritabaniproje.backend.model.User;
import com.veritabaniproje.backend.repository.AdvertisementRepository;
import com.veritabaniproje.backend.repository.MessageRepository;
import com.veritabaniproje.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TestDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AdvertisementRepository advertisementRepository;
    private final MessageRepository messageRepository;

    public TestDataLoader(UserRepository userRepository, AdvertisementRepository advertisementRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.advertisementRepository = advertisementRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            // Kullanıcı oluşturuluyor
            User user1 = new User();
            user1.setFirstName("John");
            user1.setLastName("Doe");
            user1.setEmail("john.doe@example.com");
            user1.setPassword("password123");
            user1.setPhone("1234567890");
            user1.setRole(Role.user);

            User user2 = new User();
            user2.setFirstName("Jane");
            user2.setLastName("Smith");
            user2.setEmail("jane.smith@example.com");
            user2.setPassword("securepassword");
            user2.setPhone("9876543210");
            user2.setRole(Role.user);

            userRepository.saveAll(Arrays.asList(user1, user2));

            // Advertisement oluşturuluyor
            Advertisement ad1 = new Advertisement();
            ad1.setTitle("Satılık araba");
            ad1.setDescription("2020 model, çok temiz.");
            ad1.setPrice(200000);
            ad1.setUser(user1);

            Advertisement ad2 = new Advertisement();
            ad2.setTitle("Kiralık daire");
            ad2.setDescription("Merkezi konumda, eşyalı.");
            ad2.setPrice(5000);
            ad2.setUser(user2);

            advertisementRepository.saveAll(Arrays.asList(ad1, ad2));

            // Mesajlar oluşturuluyor
            Message message1 = new Message();
            message1.setContent("Merhaba, ilan hala geçerli mi?");
            message1.setSender(user1);
            message1.setReceiver(user2);

            Message message2 = new Message();
            message2.setContent("Evet, ilan hala geçerli.");
            message2.setSender(user2);
            message2.setReceiver(user1);

            messageRepository.saveAll(Arrays.asList(message1, message2));

            System.out.println("Test verileri başarıyla yüklendi.");
        } else {
            System.out.println("Test verileri zaten yüklü. Yükleme atlanıyor.");
        }
    }
}
