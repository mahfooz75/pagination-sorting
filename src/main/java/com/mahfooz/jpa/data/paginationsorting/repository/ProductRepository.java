package com.mahfooz.jpa.data.paginationsorting.repository;

import com.mahfooz.jpa.data.paginationsorting.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
