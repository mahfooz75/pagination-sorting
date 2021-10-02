package com.mahfooz.jpa.data.paginationsorting.service;

import com.mahfooz.jpa.data.paginationsorting.entity.Product;
import com.mahfooz.jpa.data.paginationsorting.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

//    @PostConstruct
//    public void initDb(){
//        List<Product> products = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new Product("Product " + i, new Random().nextInt(100), new Random().nextInt(50000)))
//                .collect(Collectors.toList());
//        productRepository.saveAll(products);
//    }
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> findProductsWithSorting(String field){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Product> findProductsWithPagination(int offset, int pageSize){
        Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize));
        return  products;
    }

    public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field){
        Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize)
                .withSort(Sort.by(Sort.Direction.ASC,field)));
        return  products;
    }
}
