package com.veritabaniproje.backend.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false, length = 20)
    private String brand;

    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @Column(name = "address", nullable = false, length = 20)
    private String address;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "fuel_type", nullable = false, length = 20)
    private String fuelType;

    @Column(name = "transmission", nullable = false, length = 20)
    private String transmission;

    @Column(name = "body_type", nullable = false, length = 20)
    private String bodyType;

    @Column(name = "engine_capacity", nullable = false)
    private int engineCapacity;

    @Column(name = "drivetrain", nullable = false, length = 20)
    private String drivetrain;

    @Column(name = "horsepower", nullable = false)
    private int horsepower;

    // Getter ve Setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    // toString metodu
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", fuelType='" + fuelType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", drivetrain='" + drivetrain + '\'' +
                ", horsepower=" + horsepower +
                '}';
    }

    // equals ve hashCode metotları
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return price == vehicle.price &&
                year == vehicle.year &&
                engineCapacity == vehicle.engineCapacity &&
                horsepower == vehicle.horsepower &&
                Objects.equals(id, vehicle.id) &&
                Objects.equals(brand, vehicle.brand) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(address, vehicle.address) &&
                Objects.equals(fuelType, vehicle.fuelType) &&
                Objects.equals(transmission, vehicle.transmission) &&
                Objects.equals(bodyType, vehicle.bodyType) &&
                Objects.equals(drivetrain, vehicle.drivetrain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, address, price, year, fuelType, transmission, bodyType, engineCapacity, drivetrain, horsepower);
    }
}
