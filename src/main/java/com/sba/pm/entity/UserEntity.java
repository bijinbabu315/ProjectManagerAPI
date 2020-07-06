package com.sba.pm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user")
public class UserEntity {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="emp_id")
	private String employeeId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="project_id")
	@JsonIgnoreProperties(value = { "user", "task" }, allowSetters = true)
	private ProjectEntity projectData;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="task_id")
	@JsonIgnoreProperties(value = { "userEntity", "project" }, allowSetters = true)
	private TaskEntity taskEntity;
	
	@Column(name="isManager")
	private Integer isManager;

	public Integer getIsManager() {
		return isManager;
	}

	public void setIsManager(Integer isManager) {
		this.isManager = isManager;
	}

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

	public ProjectEntity getProjectData() {
		return projectData;
	}

	public void setProjectData(ProjectEntity projectData) {
		this.projectData = projectData;
	}

	public TaskEntity getTaskEntity() {
		return taskEntity;
	}

	public void setTaskEntity(TaskEntity taskEntity) {
		this.taskEntity = taskEntity;
	}




}
