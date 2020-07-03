package com.sba.pm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.pm.dao.impl.UserDaoImpl;
import com.sba.pm.entity.UserEntity;
import com.sba.pm.services.intf.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	UserDaoImpl userDao;

	@Override
	public Integer saveOrUpadte(UserEntity user) {
		return userDao.saveOrUpadte(user);
	}

	@Override
	public UserEntity getUser(Integer id) {
		return userDao.getUser(id);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public Integer deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}
}
