package com.svalero.aasfrpm.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Product {

    //TODO cuando este la api, cambiar los campos en consecuencia

    @PrimaryKey
    @NonNull
    private long id;
    @ColumnInfo
    private String product_name;
    @ColumnInfo
    private String category;
    @ColumnInfo
    private double price;
    @ColumnInfo
    private boolean available;
    @ColumnInfo
    private double latitude;
    @ColumnInfo
    private double longitude;
    @ColumnInfo
    private String user_user;


    public Product() {}

    public Product(long id, String product_name, String category, double price, boolean available, double latitude, double longitude, String user_user) {
        this.id = id;
        this.product_name = product_name;
        this.category = category;
        this.price = price;
        this.available = available;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user_user = user_user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return product_name;
    }

    public void setName(String name) {
        this.product_name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() { return price;}

    public void setPrice(double price) { this.price = price;}

    public String getUser_user() {
        return user_user;
    }

    public void setUser_user(String user_user) {
        this.user_user = user_user;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}