package com.mahfooz.jpa.data.paginationsorting;

import com.mahfooz.jpa.data.paginationsorting.dto.APIResponse;
import com.mahfooz.jpa.data.paginationsorting.entity.Product;
import com.mahfooz.jpa.data.paginationsorting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/products")
public class PaginationSortingApplication {

    @Autowired
    private ProductService productService;

    @GetMapping
    public APIResponse<List<Product>> getProducts(){
        List<Product> allProducts = productService.findAllProducts();
        return new APIResponse<>(allProducts.size(),allProducts);
    }
    public static void main(String[] args) {
        SpringApplication.run(PaginationSortingApplication.class, args);
    }

}
