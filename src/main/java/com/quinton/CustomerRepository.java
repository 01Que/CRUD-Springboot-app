package com.quinton;

import org.springframework.data.jpa.repository.JpaRepository;

//this interface will enable us to perform CRUD operation since it extends JpaRepository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
