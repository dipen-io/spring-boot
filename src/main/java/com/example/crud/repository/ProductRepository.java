package com.example.crud.repository;

import com.example.crud.model.Product;
/*
  creating an interface ProductRepority that extends JpaRespository
  JpaRepository := Provies all necessary CRUD methods (save(), findAll(), findById())
  @Repository := Marks this interface as a string data reposirotry. enabling automatci CRUD operation

*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
