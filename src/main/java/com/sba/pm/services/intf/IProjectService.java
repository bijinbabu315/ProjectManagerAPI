package com.sba.pm.services.intf;

import java.util.List;

import com.sba.pm.entity.ProjectEntity;

public interface IProjectService {
	public Integer saveOrUpadte(ProjectEntity project);
	public ProjectEntity getProject(Integer id);
	public List<ProjectEntity> getAllProjects();
	public Integer delete(Integer id);
}
