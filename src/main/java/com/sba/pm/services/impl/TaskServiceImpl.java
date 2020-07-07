package com.sba.pm.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.pm.dao.impl.TaskDaoImpl;
import com.sba.pm.dao.impl.UserDaoImpl;
import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.TaskEntity;
import com.sba.pm.entity.UserEntity;
import com.sba.pm.services.intf.ITaskService;



@Service("taskService")
public class TaskServiceImpl implements ITaskService {

	@Autowired
	TaskDaoImpl taskDao;
	
	@Autowired
	UserDaoImpl userDao;
	
	@Override
	public Integer saveOrUpdateTask(TaskEntity taskEntity) {
		Integer result = taskDao.saveOrUpdateTask(taskEntity);
		return result;
	}

	@Override
	public TaskEntity getTask(Integer id) {
		return taskDao.getTask(id);
		}

	@Override
	public List<TaskEntity> getAllTasks() {
		return taskDao.getAllTasks();
		}

	@Override
	public Integer deleteTask(Integer id) {
		return taskDao.deleteTask(id);
		}


}
