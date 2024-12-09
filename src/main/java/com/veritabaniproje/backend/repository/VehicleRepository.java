package com.veritabaniproje.backend.repository;

import com.veritabaniproje.backend.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // Belirli bir markaya ait tüm araçları getirir
    List<Vehicle> findByBrand(String brand);

    // Fiyat aralığına göre araçları getirir
    List<Vehicle> findByPriceBetween(int minPrice, int maxPrice);

    // Belirli bir yakıt türüne ait araçları getirir
    List<Vehicle> findByFuelType(String fuelType);

    // Belirli bir modele sahip araçları getirir
    List<Vehicle> findByModel(String model);

    // Yıla göre filtreleme
    List<Vehicle> findByYearGreaterThanEqual(int year);

    // Marka ve modele göre araçları filtreleme
    List<Vehicle> findByBrandAndModel(String brand, String model);


}
