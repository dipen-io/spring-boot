package com.example.crud.model;

/*
java recored :=  java feature that automatically generates constructor, getter, setter, toString(), equals, and hashCode
    makding ideal for use case DTO(data transer object to trasfter data between the server and client)
*/

public record ProductDTO(
    Long id,
    String name,
    String description,
    Double price
) {}
