package com.cs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs.demo.entity.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository <Coffee, Long> {

} //JpaRepository <TableName,Id>
