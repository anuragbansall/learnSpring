package com.anuragbansall.learnSpring;

import com.anuragbansall.learnSpring.entities.ProductEntity;
import com.anuragbansall.learnSpring.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class LearnSpringApplicationTests {
    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testProductRepository() {
        ProductEntity product = ProductEntity.builder()
                .sku("SKU12345")
                .title("Test Product")
                .price(BigDecimal.valueOf(19.99))
                .quantity(100)
                .build();

        ProductEntity savedEntity = productRepository.save(product);
        System.out.println("Saved Product: " + savedEntity);
    }

    @Test
    void testCustomFindAll() {
        List<ProductEntity> product = productRepository.customFindAll();
        System.out.println("Custom Find All Product: " + product);
    }

    @Test
    void testFindByCreatedAt() {
        List<ProductEntity> product = productRepository.findByCreatedAtGreaterThan(LocalDateTime.of(2024, 12, 11, 0, 0));
        System.out.println("Find By Created At Product: " + product);
    }
}
