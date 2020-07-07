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

	@PostMapping("/task/saveOrUpdateTask")
	public Integer createOrUpdate(@RequestBody TaskEntity task) {
		return taskService.saveOrUpdateTask(task);
	}
	
	@GetMapping("/task/getTask/{id}")
	public TaskEntity getTask(@PathVariable String id) {
		return taskService.getTask(Integer.parseInt(id));
		
		
	}
	
	@GetMapping("/task/getAllTasks")
	public List<TaskEntity> getAllTasks(){
		return taskService.getAllTasks();
		
	}
	
	@DeleteMapping("/task/deleteTask/{id}")
	public Integer deleteTask(@PathVariable String id) {
		return taskService.deleteTask(Integer.parseInt(id));
	}
}
