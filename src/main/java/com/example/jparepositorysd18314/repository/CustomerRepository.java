package com.example.jparepositorysd18314.repository;

import com.example.jparepositorysd18314.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
