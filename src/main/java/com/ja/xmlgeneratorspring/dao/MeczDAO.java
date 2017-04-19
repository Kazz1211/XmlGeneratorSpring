/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ja.xmlgeneratorspring.dao;

import com.ja.xmlgeneratorspring.entity.Log;
import com.ja.xmlgeneratorspring.entity.Mecz;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ja
 */
@Repository
public class MeczDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Mecz> callProcedure(String procedure, int... params) {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("CALL " + procedure).addEntity(Mecz.class);
        if (params != null) {
            query.setInteger("first", params[0]);
            if(params.length==2) query.setInteger("second", params[1]);
        }
        List<Mecz> results = query.list();
        session.close();
        return results;
    }
}
