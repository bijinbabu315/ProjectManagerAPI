package com.sba.pm.services.intf;

import java.util.List;

import com.sba.pm.entity.UserEntity;

public interface IUserService {
	public Integer saveOrUpadte(UserEntity userEntity);
	public UserEntity getUser(Integer id);
	public List<UserEntity> getAllUsers();
	public Integer deleteUser(Integer id);
}
