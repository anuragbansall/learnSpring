package com.anuragbansall.learnSpring.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data // Generates getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // Generates constructor with all arguments - ProductEntity(...fields)
@NoArgsConstructor // Generates no-argument constructor - ProductEntity()
@Builder // Implements the builder pattern for the class
@Entity
@Table(
        name = "products",
        uniqueConstraints = {
                @UniqueConstraint(name = "sku_unique", columnNames = {"sku"}), // Unique constraint on sku field - ensures no two products can have the same sku
                @UniqueConstraint(name = "title_price_unique", columnNames = {"title", "price"}) // Composite unique constraint on title and price - now, two products cannot have the same title and price at the same time
        },
        indexes = {
                @Index(name = "idx_price", columnList = "price"), // Index on price field - improves query performance when filtering or sorting by price
                @Index(name = "idx_sku", columnList = "sku") // Index on sku field - improves query performance when filtering or sorting by sku)
        }
) // Maps this entity to the "products" table in the database
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the product

    @Column(nullable = false, length = 20)
    private String sku; // Stock Keeping Unit, unique code for the product

    private String title;

    private BigDecimal price;

    private Integer quantity;

    @CreationTimestamp // Automatically sets the timestamp when the entity is created - only once
    private LocalDateTime createdAt;

    @UpdateTimestamp // Automatically updates the timestamp when the entity is updated - every time
    private LocalDateTime updatedAt;
}
