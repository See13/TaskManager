package com.learn.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Task")
public class Task implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "taskId")
	private long taskId;

	@Column(name = "task")
	private String task;

	@Column(name = "priority")
	private int priority;

	@Column(name = "startDate")
	private LocalDate startDate;

	@Column(name = "endDate")
	private LocalDate endDate;
	private String isTaskEnded;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_task_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ParentTask parent_task;

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public ParentTask getParentTask() {
		return parent_task;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parent_task = parentTask;
	}

	public String getIsTaskEnded() {
		return isTaskEnded;
	}

	public void setIsTaskEnded(String isTaskEnded) {
		this.isTaskEnded = isTaskEnded;
	}

	public Task() {
	}

	public Task(long taskId, String task, int priority, LocalDate startDate, LocalDate endDate, String isTaskEnded,
			ParentTask parent_task) {
		super();
		this.taskId = taskId;
		this.task = task;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isTaskEnded = isTaskEnded;
		this.parent_task = parent_task;
	}

}
