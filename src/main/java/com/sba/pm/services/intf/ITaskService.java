package com.sba.pm.services.intf;

import java.util.List;

import com.sba.pm.entity.TaskEntity;

public interface ITaskService {
	public Integer saveOrUpadte(TaskEntity taskEntity);
	public TaskEntity getTask(Integer id);
	public List<TaskEntity> view();
	public Integer delete(Integer id);
}
