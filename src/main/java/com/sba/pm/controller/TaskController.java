package com.sba.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sba.pm.entity.TaskEntity;
import com.sba.pm.services.impl.ParentTaskServiceImpl;
import com.sba.pm.services.impl.TaskServiceImpl;


@RestController
@CrossOrigin(origins = "*")
public class TaskController {
	
	@Autowired
	private TaskServiceImpl taskService;
	@Autowired
	private  ParentTaskServiceImpl parentTaskService;

	@PostMapping("/task/saveorupdate")
	public Integer createOrUpdate(@RequestBody TaskEntity task) {
//		task.setParentTask(parentTaskService.getParentTask(Integer.parseInt(task.getParentTask())));
		return taskService.saveOrUpadte(task);
	}
	
	@GetMapping("/task/getTask/{id}")
	public TaskEntity getTask(@PathVariable String id) {
		return taskService.getTask(Integer.parseInt(id));
		
		
	}
	
	@GetMapping("/task/getAllTasks")
	public List<TaskEntity> getAllTasks(){
		return taskService.view();
		
	}
	
	@DeleteMapping("/task/delete/{id}")
	public Integer deleteTask(@PathVariable String id) {
		return taskService.delete(Integer.parseInt(id));
	}
}
