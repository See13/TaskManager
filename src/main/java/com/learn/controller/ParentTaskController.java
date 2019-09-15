package com.learn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.ParentTask;
import com.learn.repository.ParentTaskRepository;

@RestController @CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1")
public class ParentTaskController {/*
	@Autowired
    private ParentTaskRepository parentTaskRepository;
	
	@GetMapping("/parenttasks")
    public List<ParentTask> getAllParentTasks() {
        return parentTaskRepository.findAll();
    }
	@PostMapping("/parentTask")
	public ParentTask createParentTask(@Valid @RequestBody ParentTask parentTask ){
		return parentTaskRepository.save(parentTask);
	}
        
    @DeleteMapping("/deleteParentTaskById/{parenttaskid}")
    public long deleteTask(@PathVariable  long parenttaskid){
        	parentTaskRepository.deleteById(parenttaskid);
    		return parenttaskid;		
    }
*/}
