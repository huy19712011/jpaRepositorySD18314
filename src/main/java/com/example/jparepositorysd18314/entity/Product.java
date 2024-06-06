package com.example.jparepositorysd18314.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQuery(
        name = "Product.findByNameV3",
        query = "SELECT p FROM Product p WHERE p.name=?1"
)
@NamedNativeQuery(
        name = "Product.findByNameV4",
        query = "SELECT * FROM product p WHERE p.name=?1",
        resultClass = Product.class
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
