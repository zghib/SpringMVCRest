package com.zghib.rest.dao;

import java.util.List;

import com.zghib.rest.model.User;

public interface UserDao {

    User findById(int id);


    List<User> findAllUsers();

}
