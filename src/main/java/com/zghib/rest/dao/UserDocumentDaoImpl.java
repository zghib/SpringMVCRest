package com.zghib.rest.dao;

import java.util.List;

import com.zghib.rest.model.UserDocument;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDocumentDao")
public class UserDocumentDaoImpl extends AbstractDao<Integer, UserDocument> implements UserDocumentDao{

    @SuppressWarnings("unchecked")
    public List<UserDocument> findAll() {
        Criteria crit = createEntityCriteria();
        return (List<UserDocument>)crit.list();
    }

    public UserDocument findById(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<UserDocument> findAllByUserId(int userId){
        Criteria crit = createEntityCriteria();
        Criteria userCriteria = crit.createCriteria("user");
        userCriteria.add(Restrictions.eq("id", userId));
        return (List<UserDocument>)crit.list();
    }


}
