package com.veritabaniproje.backend.controller;

import com.veritabaniproje.backend.model.Advertisement;
import com.veritabaniproje.backend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping
    public ResponseEntity<Advertisement> addAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement newAd = advertisementService.saveAdvertisement(advertisement);
        return ResponseEntity.ok(newAd);
    }


    @GetMapping("/advertisements/by-user/{userId}")
    public ResponseEntity<List<Advertisement>> getAdvertisementsByUserId(@PathVariable Long userId) {
        List<Advertisement> advertisements = advertisementService.getAdvertisementsByUserId(userId);
        return ResponseEntity.ok(advertisements); // Liste döner
    }


    @GetMapping
    public ResponseEntity<List<Advertisement>> getAllAdvertisements() {
        return ResponseEntity.ok(advertisementService.getAllAdvertisements());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdvertisement(@PathVariable Long id) {
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.ok("Advertisement deleted successfully.");
    }
}
