package com.zghib.rest.service;

import java.util.List;

import com.zghib.rest.dao.UserDao;
import com.zghib.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	public User findById(int id) {
		return dao.findById(id);
	}


	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}
}
