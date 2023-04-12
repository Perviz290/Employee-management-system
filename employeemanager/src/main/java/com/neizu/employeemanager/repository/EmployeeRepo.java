package com.neizu.employeemanager.repository;

import com.neizu.employeemanager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

  //  @Query(value = "SELECT * FROM employee WHERE id = :id", nativeQuery = true)
   // Employee findEmployeeById(@Param("id") Long id);
}


