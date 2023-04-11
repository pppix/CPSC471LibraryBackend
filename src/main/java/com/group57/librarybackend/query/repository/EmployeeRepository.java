package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group57.librarybackend.query.model.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> findAllNative();

    @Query(value = "SELECT * FROM employee t WHERE t.ID LIKE  %?1%", nativeQuery = true)
    Employee findByProductIDEqualsNative(int ProductID);

}