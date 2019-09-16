package com.learn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARENTTASK")
public class ParentTask implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "parent_task_id")
	private long parent_task_id;
	@Column(name = "parent_task")
	private String parentTask;

	public long getParentTaskId() {
		return parent_task_id;
	}

	public void setParentTaskId(long parentTaskId) {
		this.parent_task_id = parentTaskId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public ParentTask() {
	}

	public ParentTask(int parent_task_id, String parentTask) {
		super();
		this.parent_task_id = parent_task_id;
		this.parentTask = parentTask;
	}

	@Override
	public String toString() {
		return "Task [id=" + parent_task_id + ", parentTask=" + parentTask + "]";
	}
}
