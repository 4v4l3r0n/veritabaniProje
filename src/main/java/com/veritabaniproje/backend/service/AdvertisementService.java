package com.veritabaniproje.backend.service;

import com.veritabaniproje.backend.model.Advertisement;
import com.veritabaniproje.backend.repository.AdvertisementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

    public AdvertisementService(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    /**
     * Save a new advertisement.
     *
     * @param advertisement Advertisement object to save
     * @return Saved advertisement object
     */
    public Advertisement saveAdvertisement(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    /**
     * Get all advertisements.
     *
     * @return List of advertisements
     */
    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    /**
     * Get advertisements by user ID.
     *
     * @param userId ID of the user
     * @return List of advertisements belonging to the user
     */
    public List<Advertisement> getAdvertisementsByUserId(Long userId) {
        return advertisementRepository.findByUserId(userId);
    }

    /**
     * Get advertisements by price range.
     *
     * @param minPrice Minimum price
     * @param maxPrice Maximum price
     * @return List of advertisements within the price range
     */
    public List<Advertisement> getAdvertisementsByPriceRange(int minPrice, int maxPrice) {
        return advertisementRepository.findByPriceBetween(minPrice, maxPrice);
    }

    /**
     * Get advertisements by vehicle brand.
     *
     * @param brand Vehicle brand
     * @return List of advertisements with the specified brand
     */
    public List<Advertisement> getAdvertisementsByBrand(String brand) {
        return advertisementRepository.findByVehicle_Brand(brand);
    }

    /**
     * Delete an advertisement by its ID.
     *
     * @param id Advertisement ID
     */
    public void deleteAdvertisement(Long id) {
        advertisementRepository.deleteById(id);
    }
}
