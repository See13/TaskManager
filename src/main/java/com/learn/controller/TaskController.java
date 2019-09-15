package com.learn.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.ParentTask;
import com.learn.model.Task;
import com.learn.repository.ParentTaskRepository;
import com.learn.repository.TaskRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class TaskController {
	private static final Logger logger = LogManager.getLogger(TaskController.class);
	@Autowired
    private TaskRepository taskRepository;
	@Autowired
    private ParentTaskRepository parentTaskRepository;
	
	@PostMapping("/parentTask")
	public ParentTask createParentTask(ParentTask parentTask ){
		logger.info("Enter into createParentTaskmethod in controller.......");
		return parentTaskRepository.save(parentTask);
	}
	@GetMapping("/parentlist")
	public List<ParentTask> getParentTasks(){
		logger.info("Enter into getParentTasks method in controller.......");
		return parentTaskRepository.findAll();
		
	}
	@GetMapping("/findByParentTaskId/{parenttaskid}")
	public Optional<ParentTask> getParentTask(@PathVariable long parenttaskid){
		logger.info("Enter into getParentTask method in controller.......");
		return parentTaskRepository.findById(parenttaskid);
		
	}
	@PostMapping("/addtask")
	public Task createTask(@RequestBody Task task ){
		logger.info("Enter into createTask method in controller.......");
		task.setIsTaskEnded("false");
		ParentTask newParentTask = new ParentTask();
		newParentTask.setParentTask(task.getTask());
		newParentTask.setParentTaskId(task.getTaskId());
		parentTaskRepository.save(newParentTask);
		return taskRepository.save(task);
	}
	@PostMapping("/parenttask/{parenttaskid}/addtask")
	public Task createTaskInProject(@PathVariable long parenttaskid, @RequestBody Task task ){
		logger.info("Enter into createTask method in controller.......");
		task.setIsTaskEnded("false");
		ParentTask newParentTask = new ParentTask();
		newParentTask.setParentTask(task.getTask());
		newParentTask.setParentTaskId(task.getTaskId());
		parentTaskRepository.save(newParentTask);
		try {
			return parentTaskRepository.findById(parenttaskid).map(parentTask -> {
					task.setParentTask(parentTask);
			    return taskRepository.save(task);
			}).orElseThrow(() -> new Exception("parenttaskid " + parenttaskid + " not found"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		return taskRepository.save(task);
	}
	@GetMapping("/list")
	public List<Task> getTasks(){
		logger.info("Enter into getTasks method in controller.......");
		return taskRepository.findAll();
		
	}
	@GetMapping("/findById/{taskid}")
	public Optional<Task> getTask(@PathVariable long taskid){
		logger.info("Enter into getTask method in controller.......");
		return taskRepository.findById(taskid);
		
	}
	@DeleteMapping("/deleteById/{taskid}")
	public long deleteTask(@PathVariable  long taskid){
		logger.info("Enter into deleteTask method in controller.......");
		 taskRepository.deleteById(taskid);
		return taskid;		
	}
	@PutMapping("/updateById/{taskid}")
	public Task updateTask(@RequestBody Task task){
		logger.info("Enter into updateTask method in controller.......");
		return taskRepository.save(task);
	}
	@PutMapping("/IsTaskEnded/{taskid}")
	public Task TaskEnded(@RequestBody Task task){
		logger.info("Enter into TaskEnded method in controller......."+task.getIsTaskEnded());
		task.setIsTaskEnded("True");
		return taskRepository.save(task);
	}
}
