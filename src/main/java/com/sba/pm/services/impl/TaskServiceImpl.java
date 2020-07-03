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
	public Integer saveOrUpadte(TaskEntity taskEntity) {
		ProjectEntity projectEntity = taskEntity.getProject();
		Integer result = taskDao.saveOrUpadte(taskEntity);
		UserEntity userEntity = taskEntity.getUserEntity();
		if(result > 0 && userEntity!= null) {
			userEntity.setTaskEntity(taskEntity);
			userEntity.setProjectEntity(projectEntity);
			userDao.saveOrUpadte(userEntity);
		}
		return result;
	}

	@Override
	public TaskEntity getTask(Integer id) {
		return taskDao.getTask(id);
		}

	@Override
	public List<TaskEntity> view() {
		return taskDao.view();
		}

	@Override
	public Integer delete(Integer id) {
		return taskDao.delete(id);
		}


}
