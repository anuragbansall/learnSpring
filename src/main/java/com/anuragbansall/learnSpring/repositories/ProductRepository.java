package com.anuragbansall.learnSpring.repositories;

import com.anuragbansall.learnSpring.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // Custom query to fetch all products
    @Query("SELECT p FROM ProductEntity p")
    List<ProductEntity> customFindAll();

    // Defination for this will be automatically provided by Spring Data JPA based on method name
    List<ProductEntity> findByCreatedAtGreaterThan(LocalDateTime createdAt);

    List<ProductEntity> findAllByOrderByPrice();

    List<ProductEntity> findBy(Sort sort);

    List<ProductEntity> findBy(Pageable pageable); // Returns page you can also use findAll
}
