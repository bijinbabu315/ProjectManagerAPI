package com.sba.pm.dao.intf;

import java.util.List;

import com.sba.pm.entity.TaskEntity;

public interface ITaskDao {
	public Integer saveOrUpdateTask(TaskEntity task);

	public TaskEntity getTask(Integer id);

	public List<TaskEntity> getAllTasks();

	public Integer deleteTask(Integer id);
}
