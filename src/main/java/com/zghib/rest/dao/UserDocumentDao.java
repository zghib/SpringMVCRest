package com.zghib.rest.dao;

import java.util.List;

import com.zghib.rest.model.UserDocument;


public interface UserDocumentDao {

    List<UserDocument> findAll();

    UserDocument findById(int id);

    List<UserDocument> findAllByUserId(int userId);

}