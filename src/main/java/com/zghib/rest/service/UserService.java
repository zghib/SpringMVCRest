package com.zghib.rest.service;

import java.util.List;

import com.zghib.rest.model.User;

public interface UserService {

    User findById(int id);

    List<User> findAllUsers();

}
