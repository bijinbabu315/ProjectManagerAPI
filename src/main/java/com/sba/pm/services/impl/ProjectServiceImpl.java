package com.sba.pm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.pm.dao.impl.ProjectDaoImpl;
import com.sba.pm.dao.impl.UserDaoImpl;
import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.UserEntity;
import com.sba.pm.services.intf.IProjectService;


@Service("projectService")
public class ProjectServiceImpl implements IProjectService {
	
	@Autowired
	private ProjectDaoImpl projectDao;
	
	@Autowired
	private UserDaoImpl userDaoImpl;

	@Override
	public Integer saveOrUpadte(ProjectEntity project) {
		Integer result = projectDao.saveOrUpadte(project);
		if( result > 0 && project.getUserEntity() != null) {
		UserEntity userEntity = project.getUserEntity();
		userEntity.setProjectEntity(project);
		userDaoImpl.saveOrUpadte(userEntity);
		}
		
		return result;
	}
	
	@Override
	public ProjectEntity getProject(Integer id) {
		return projectDao.getProject(id);
	}

	@Override
	public List<ProjectEntity> getAllProjects() {
		return projectDao.getAllProjects();
	}

	@Override
	public Integer delete(Integer id) {
		return projectDao.delete(id);
	}
}
