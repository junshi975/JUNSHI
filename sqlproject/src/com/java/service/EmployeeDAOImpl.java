package com.java.service;

import com.java.bean.Employees;
import com.java.dao.BaseDAO;
import com.java.dao.EmployeeDAO;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-07 23:00
 */
public class EmployeeDAOImpl extends BaseDAO<Employees> implements EmployeeDAO {


    @Override
    public List<Employees> getAllEmployees(Connection conn) throws SQLException {

        String sql = "select id,name,age,salary,position,status,bonus,stock,model,display from Team";

        List<Employees> beanList = getBeanList(conn, sql);

        return beanList;
    }

    @Override
    public int insertEmployee(Connection conn, Employees em) {

        String sql = "insert into team(id,name,age,salary,position,status,bonus,stock,model,display)values(?,?,?,?,?,?,?,?,?,?)";

        int update = update(conn, sql, em.getID(), em.getName(), em.getAge(), em.getSalary(),
                em.getPosition(), em.getStatus(), em.getBonus(), em.getStock(),
                em.getModel(), em.getDisplay());

        return update;

    }

    @Override
    public int deleteEmployee(Connection conn, int ID) {

        String sql = "delete from team where id = ?";

        int update = update(conn, sql, ID);

        return update;


    }




    @Override
    public Employees getEmployeesId(Connection conn, int id) {

        String sql = "select id,name,age,salary,position,status,bonus,stock,model,display from team where id = ?";

        Employees bean = getBean(conn, sql, id);

        return bean;
    }

    @Override
    public int updateEmployee(Connection conn, Employees em, int id) {

        String sql = "update team set name = ?,age = ?,salary = ?,position = ?,status = ?,bonus = ?,stock = ?,model = ?,display = ? where id = ?";

        int update = update(conn, sql, em.getName(), em.getAge(), em.getSalary(), em.getPosition(), em.getStatus(), em.getBonus(), em.getStock(), em.getModel(), em.getDisplay(), id);

        return update;
    }

    @Override
    public Long getTeamCount(Connection conn) {

        String sql = "select count(*) from team";

        Long value = getValue(conn, sql);

        return value;
    }

    @Override
    public Long getTeamCount(Connection conn, String position) {


        String sql = "select count(*) from team where position = ?";


        Long value = getValue(conn, sql, position);

        return value;
    }

    @Override
    public int updateStatus(Connection conn, String status, int id) {
        String sql = "update team set status = ? where id = ?";

        int update = update(conn, sql, status, id);

        return update;
    }


}
