package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.model.ParentTask;

/**
 * This is an interface which extends JpaRepository and performs CRUD
 * operation.
 * 
 * @author SeemaYadav
 * @version 1.0
 * @since 09-10-2019
 */
@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTask, Long> {

}
