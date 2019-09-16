package com.learn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.model.ParentTask;
import com.learn.repository.ParentTaskRepository;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner {
	private static final Logger logger = LogManager.getLogger(TaskManagerApplication.class);

	@Autowired
	private ParentTaskRepository parentTaskRepository;

	public static void main(String[] args) {
		logger.info("Enter into main method in TaskManagerApplication.......");
		SpringApplication.run(TaskManagerApplication.class, args);
		logger.info("Exit from main method in TaskManagerApplication.......");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Enter into run method in TaskManagerApplication.......");

		parentTaskRepository.save(new ParentTask(1, "ParentTask1"));
		parentTaskRepository.save(new ParentTask(2, "ParentTask2"));
		parentTaskRepository.save(new ParentTask(3, "ParentTask3"));
		parentTaskRepository.save(new ParentTask(4, "ParentTask4"));
		parentTaskRepository.save(new ParentTask(5, "ParentTask5"));
		parentTaskRepository.save(new ParentTask(6, "ParentTask6"));
		
		logger.info("Exit from run method in TaskManagerApplication.......");
	}

}
