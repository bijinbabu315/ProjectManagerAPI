package com.sba.pm.dao.intf;

import java.util.List;

import com.sba.pm.entity.UserEntity;

public interface IUserDao {
	public Integer saveOrUpadte(UserEntity user);

	public UserEntity getUser(Integer id);

	public List<UserEntity> getAllUsers();

	public Integer deleteUser(Integer id);
}
