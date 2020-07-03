package com.sba.pm.dao.intf;

import java.util.List;

import com.sba.pm.entity.ProjectEntity;

public interface IProjectDao {
	public Integer saveOrUpadte(ProjectEntity projectEntity);

	public ProjectEntity getProject(Integer id);

	public List<ProjectEntity> getAllProjects();

	public Integer delete(Integer id);
}
