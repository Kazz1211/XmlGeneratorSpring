/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ja.xmlgeneratorspring.dao;

import com.ja.xmlgeneratorspring.entity.Log;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ja
 */
@Repository
public class LogDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void add(Timestamp time, String ip, boolean ifExecuted) {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("CALL insertLog(:timestamp,:ip,:ifExecuted)")
                .setParameter("timestamp", time)
                .setParameter("ip", ip)
                .setParameter("ifExecuted", ifExecuted);
        query.executeUpdate();
        session.close();
    }
    
    @Transactional
    public List<Log> checkLastLogs(Timestamp from, Timestamp to, String ip) {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("CALL checkLastLogs(:ip,:from,:to)")
                .addEntity(Log.class)
                .setParameter("to", to)
                .setParameter("ip", ip)
                .setParameter("from", from);
        List<Log> results = query.list();
        session.close();
        return results;
    }
}
