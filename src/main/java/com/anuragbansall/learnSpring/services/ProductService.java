package com.anuragbansall.learnSpring.services;

import com.anuragbansall.learnSpring.dto.ProductDto;
import com.anuragbansall.learnSpring.entities.ProductEntity;
import com.anuragbansall.learnSpring.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductDto> getAllProducts(String sortBy, Integer page, Integer pageSize) {
//        List<ProductEntity> productEntities = productRepository.findBy(Sort.by(
//                Sort.Order.desc(sortBy),
//                Sort.Order.asc("id")
//        )); // if two or more row have same sortBy, then sort it by id

        List<ProductEntity> productEntities = productRepository.findBy(
                PageRequest.of(page, pageSize, Sort.by(
                        Sort.Direction.ASC,
                        sortBy
                        , "price"
                ))
        );

        return productEntities
//                .getContent() // Page -> List
                .stream()
                .map(entity -> modelMapper.map(entity, ProductDto.class))
                .toList();
    }

    public ProductDto createProduct(ProductDto request) {
        ProductEntity productEntity = modelMapper.map(request, ProductEntity.class);
        productEntity = productRepository.save(productEntity);

        return modelMapper.map(productEntity, ProductDto.class);
    }
}
