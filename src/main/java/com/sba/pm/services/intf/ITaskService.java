package com.sba.pm.services.intf;

import java.util.List;

import com.sba.pm.entity.TaskEntity;

public interface ITaskService {
	public Integer saveOrUpdateTask(TaskEntity taskEntity);
	public TaskEntity getTask(Integer id);
	public List<TaskEntity> getAllTasks();
	public Integer deleteTask(Integer id);
}
