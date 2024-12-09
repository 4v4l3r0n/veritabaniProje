package com.veritabaniproje.backend.service;

import com.veritabaniproje.backend.model.Vehicle;
import com.veritabaniproje.backend.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            vehicle.setBrand(updatedVehicle.getBrand());
            vehicle.setModel(updatedVehicle.getModel());
            vehicle.setAddress(updatedVehicle.getAddress());
            vehicle.setPrice(updatedVehicle.getPrice());
            vehicle.setYear(updatedVehicle.getYear());
            vehicle.setFuelType(updatedVehicle.getFuelType());
            vehicle.setTransmission(updatedVehicle.getTransmission());
            vehicle.setBodyType(updatedVehicle.getBodyType());
            vehicle.setEngineCapacity(updatedVehicle.getEngineCapacity());
            vehicle.setDrivetrain(updatedVehicle.getDrivetrain());
            vehicle.setHorsepower(updatedVehicle.getHorsepower());
            return vehicleRepository.save(vehicle);
        } else {
            throw new RuntimeException("Vehicle not found with id " + id);
        }
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    // Vehicle kaydetme
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);  // save() metodu JpaRepository tarafından sağlanır
    }
}
