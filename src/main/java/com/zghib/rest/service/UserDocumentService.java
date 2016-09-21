package com.zghib.rest.service;

import java.util.List;

import com.zghib.rest.model.UserDocument;

public interface UserDocumentService {

    UserDocument findById(int id);

    List<UserDocument> findAll();

    List<UserDocument> findAllByUserId(int id);
}
