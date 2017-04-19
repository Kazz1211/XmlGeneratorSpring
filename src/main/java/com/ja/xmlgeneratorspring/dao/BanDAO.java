/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ja.xmlgeneratorspring.dao;

import com.ja.xmlgeneratorspring.entity.Ban;
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
public class BanDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void add(String ip) {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("CALL addBan(:ip)")
                .setParameter("ip", ip);
        query.executeUpdate();
        session.close();
    }

    @Transactional
    public boolean checkBan(String ip) {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("CALL checkBan(:ip)")
                .addEntity(Ban.class)
                .setParameter("ip", ip);
        List<Ban> results = query.list();
        session.close();
        return !results.isEmpty();
    }
}
