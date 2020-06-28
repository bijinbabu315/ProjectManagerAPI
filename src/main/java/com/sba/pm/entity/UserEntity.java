package com.sba.pm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="emp_id")
	private String employeeId;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectEntity projectEntity;
	
	@ManyToOne
	@JoinColumn(name="task_id")
	private TaskEntity taskEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public ProjectEntity getProject() {
		return projectEntity;
	}

	public void setProject(ProjectEntity projectEntity) {
		this.projectEntity = projectEntity;
	}

	public TaskEntity getTask() {
		return taskEntity;
	}

	public void setTask(TaskEntity taskEntity) {
		this.taskEntity = taskEntity;
	}
}
