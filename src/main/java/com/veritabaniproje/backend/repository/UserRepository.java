package com.veritabaniproje.backend.repository;

import com.veritabaniproje.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Email ile kullanıcıyı bulur
    Optional<User> findByEmail(String email);

    // Belirli bir role sahip tüm kullanıcıları bulur
    List<User> findByRole(String role);

    // Belirli bir isim veya soyadına göre kullanıcıları arar
    List<User> findByFirstNameOrLastName(String firstName, String lastName);

    // Email adresi var mı kontrol eder
    boolean existsByEmail(String email);
}
