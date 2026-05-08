package com.example.demo.model;

/*
    @Entity := Marks this class as a jpa , which will be mapped to a table in db
    @id := primary key
*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;

    // geter & setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getDescrition() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
