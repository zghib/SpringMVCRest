package com.zghib.rest.service;

import java.util.List;

import com.zghib.rest.dao.UserDocumentDao;
import com.zghib.rest.model.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDocumentService")
@Transactional
public class UserDocumentServiceImpl implements UserDocumentService{

    @Autowired
    UserDocumentDao dao;

    public UserDocument findById(int id) {
        return dao.findById(id);
    }

    public List<UserDocument> findAll() {
        return dao.findAll();
    }

    public List<UserDocument> findAllByUserId(int userId) {
        return dao.findAllByUserId(userId);
    }
}
