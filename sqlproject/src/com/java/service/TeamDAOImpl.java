package com.java.service;

import com.java.bean.Employees;
import com.java.bean.Team;
import com.java.dao.BaseDAO;
import com.java.dao.TeamDAO;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-07 23:23
 */
public class TeamDAOImpl extends BaseDAO<Team> implements TeamDAO {

    EmployeeDAOImpl emDao = new EmployeeDAOImpl();

    @Override
    public List<Team> getAllTeam(Connection conn) {

        String sql = "select TID,ID,name,age,salary,position,bonus,stock from teamlist";

        List<Team> beanList = getBeanList(conn, sql);

        return beanList;
    }

    @Override
    public int insertTeam(Connection conn, int employeeId) {

        String sql = "INSERT INTO teamlist(ID,name,age,salary,position,bonus,stock)SELECT ID,name,age,salary,position,bonus,stock FROM team WHERE id = ?";

        int updateCount = update(conn, sql, employeeId);

        return updateCount;
    }

    @Override
    public int deleteTeamMamberTID(Connection conn, int TID) {


        String sql = "delete from teamlist where TID = ?";
        int deleteCount = update(conn, sql, TID);

        return deleteCount;
    }

    @Override
    public Team getTeamTId(Connection conn, int TID) {


        String sql = "select TID,ID,name,age,salary,position,bonus,stock from teamlist where TID = ?";

        Team bean = getBean(conn, sql, TID);

        return bean;
    }

    @Override
    public int updateTeam(Connection conn, Team team, int TID) {

        String sql = "update teamlist set ID = ?,name = ?,age = ?,salary = ?,position = ?,bonus = ?,stock = ? where TID = ?";

        update(conn, sql, team.getID(), team.getName(), team.getAge(), team.getSalary(), team.getPosition(), team.getBouns(), team.getStock(), TID);

        return 0;
    }

    @Override
    public int deleteAllTeam(Connection conn) {


        String sql = "truncate  teamlist";

        int update = update(conn, sql);

        return update;
    }

    @Override
    public Long getCount(Connection conn) {

        String sql = "select count(*) from teamlist";

        Long value = getValue(conn, sql);
        return value;
    }

    @Override
    public Long getTeamCount(Connection conn, String position) {


        String sql = "select count(*) from teamlist where position = ?";


        Long value = getValue(conn, sql, position);

        return value;
    }

    @Override
    public boolean isExist(Connection conn, int employeeId) {

        List<Team> allTeam = getAllTeam(conn);

        Iterator<Team> iterator = allTeam.iterator();

        while (iterator.hasNext()) {

            Team team = iterator.next();

            int id = team.getID();

            return id == employeeId;
        }

        return false;
    }


}
