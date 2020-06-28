package com.sba.pm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class TaskEntity {

		@Id
		@Column(name="task_id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		
		@ManyToOne
		@JoinColumn(name="parent_id")
		private ParentTaskEntity parentTaskEntity;
		
		@ManyToOne
		@JoinColumn(name="project_id")
		private ParentTaskEntity project;
		
		@Column(name="task")
		private String task;
		
		@Column(name ="start_dt")
		private Date startDate;
		
		@Column(name="end_dt")
		private Date endDate;
		
		@Column(name="priorty")
		private Integer priorty;
		
		@Column(name="status")
		private Integer status;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public ParentTaskEntity getParentTask() {
			return parentTaskEntity;
		}

		public void setParentTask(ParentTaskEntity parentTaskEntity) {
			this.parentTaskEntity = parentTaskEntity;
		}

		public ParentTaskEntity getProject() {
			return project;
		}

		public void setProject(ParentTaskEntity project) {
			this.project = project;
		}

		public String getTask() {
			return task;
		}

		public void setTask(String task) {
			this.task = task;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public Integer getPriorty() {
			return priorty;
		}

		public void setPriorty(Integer priorty) {
			this.priorty = priorty;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}
}
