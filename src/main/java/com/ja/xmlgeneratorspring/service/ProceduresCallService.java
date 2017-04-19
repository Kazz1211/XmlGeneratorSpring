/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ja.xmlgeneratorspring.service;

import com.ja.xmlgeneratorspring.dao.MeczDAO;
import com.ja.xmlgeneratorspring.dao.LogDAO;
import com.ja.xmlgeneratorspring.dao.BanDAO;
import com.ja.xmlgeneratorspring.entity.Log;
import com.ja.xmlgeneratorspring.entity.Mecz;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ja
 */
@Service
public class ProceduresCallService {

    @Autowired
    private BanDAO banDao;
    @Autowired
    private LogDAO logDao;
    @Autowired
    private MeczDAO meczDao;
    private final int TIME_TO_LOGS_CHECK_FOR_BAN = 300000;
    private final int LOGS_COUNT_TO_BAN = 150;
    private final int TIME_FOR_NEXT_CALL = 5000;

    private void addBan(String ip) {
        banDao.add(ip);
    }

    private boolean checkBan(String ip, HttpSession session) {
        return (session.getAttribute("ban") != null || banDao.checkBan(ip));
    }

    private boolean checkIfShouldBeBanned(String ip) {
        List<Log> lastLogs = logDao.checkLastLogs(new Timestamp(System.currentTimeMillis() - TIME_TO_LOGS_CHECK_FOR_BAN),
                new Timestamp(System.currentTimeMillis()),
                ip);
        return lastLogs.size() >= LOGS_COUNT_TO_BAN;
    }

    private boolean checkIfCallRepeated(String ip, HttpSession session) {
        if (!checkIfCallRepeatedInSession(session)) {
            List<Log> lastLogs = logDao.checkLastLogs(new Timestamp(System.currentTimeMillis() - TIME_FOR_NEXT_CALL),
                    new Timestamp(System.currentTimeMillis()), ip);
            return !lastLogs.isEmpty();
        } else {
            return true;
        }
    }

    private boolean checkIfCallRepeatedInSession(HttpSession session) {
        return session.getAttribute("lastLog") != null
                && System.currentTimeMillis() - ((Timestamp) session.getAttribute("lastLog")).getTime() > TIME_FOR_NEXT_CALL;
    }

    public List<Mecz> getData(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        List<Mecz> list = null;
        String procedure = params.get("procedure")[0];
        int[] procedureParams = null;
        if (params.size() == 5) {
            procedure += "(:first,:second)";
            procedureParams = new int[2];
            procedureParams[0] = Integer.parseInt(params.get("first")[0]);
            procedureParams[1] = Integer.parseInt(params.get("second")[0]);
        } else if (params.size() == 4) {
            procedure += "(:first)";
            procedureParams = new int[1];
            procedureParams[0] = Integer.parseInt(params.get("first")[0]);
        }
        list = meczDao.callProcedure(procedure, procedureParams);
        return list;
    }

    public boolean checkIfCallToExecute(HttpSession session, String ip, HttpServletResponse response) throws IOException {
        boolean ifToExecute = false;
        if (!checkBan(ip, session)) {
            if (checkIfShouldBeBanned(ip)) {
                addBan(ip);
                response.sendRedirect("/XMLGeneratorSpring/newban");
            } else if (checkIfCallRepeated(ip, session)) {
                logDao.add(new Timestamp(System.currentTimeMillis()), ip, false);
                session.setAttribute("lastLog", new Timestamp(System.currentTimeMillis()));
                response.sendRedirect("/XMLGeneratorSpring/denied");
            } else {
                logDao.add(new Timestamp(System.currentTimeMillis()), ip, true);
                session.setAttribute("lastLog", new Timestamp(System.currentTimeMillis()));
                ifToExecute = true;
            }
        } else {
            response.sendRedirect("/XMLGeneratorSpring/ban");
        }
        return ifToExecute;
    }

    public void setBanDao(BanDAO banDao) {
        this.banDao = banDao;
    }

    public void setLogDao(LogDAO logDao) {
        this.logDao = logDao;
    }

    public void setMeczDao(MeczDAO meczDao) {
        this.meczDao = meczDao;
    }
}
