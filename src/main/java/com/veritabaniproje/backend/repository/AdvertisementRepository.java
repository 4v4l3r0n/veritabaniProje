package com.veritabaniproje.backend.repository;

import com.veritabaniproje.backend.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findByUserId(Long userId);
    List<Advertisement> findByPriceBetween(int minPrice, int maxPrice);
    List<Advertisement> findByVehicle_Brand(String brand);

}
