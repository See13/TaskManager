package com.learn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.model.ParentTask;

/**
 * This v is an interface which extends JpaRepository and
 * perfroms crud operation.
 * 
 * @author SeemaYadav
 * @version 1.0
 * @since 09-10-2019
 */
@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTask, Long>{
	//Optional<ParentTask> findByIdAndPostId(Long id, Long postId);

}
