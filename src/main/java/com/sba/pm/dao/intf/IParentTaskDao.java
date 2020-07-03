package com.sba.pm.dao.intf;

import java.util.List;

import com.sba.pm.entity.ParentTaskEntity;

public interface IParentTaskDao {
	public Integer saveOrUpadte(ParentTaskEntity parentTaskEntity);

	public ParentTaskEntity getTaskById(Integer id);

	public List<ParentTaskEntity> getAllParentTask();

	public Integer deleteTaskById(Integer id);
}
