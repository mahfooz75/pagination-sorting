package com.mahfooz.jpa.data.paginationsorting.controller;

import com.mahfooz.jpa.data.paginationsorting.dto.APIResponse;
import com.mahfooz.jpa.data.paginationsorting.entity.Product;
import com.mahfooz.jpa.data.paginationsorting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = productService.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/{field}")
    public APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
        List<Product> allProducts = productService.findProductsWithSorting(field);
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset,@PathVariable int pageSize) {
        Page<Product> allProducts = productService.findProductsWithPagination(offset,pageSize);
        return new APIResponse<>(allProducts.getSize(), allProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}/{field}")
    public APIResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset,
                                                                       @PathVariable int pageSize,
                                                                       @PathVariable String field) {
        Page<Product> allProducts = productService.findProductsWithPaginationAndSorting(offset,pageSize,field);
        return new APIResponse<>(allProducts.getSize(), allProducts);
    }
}
