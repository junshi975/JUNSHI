package com.java.test;

import com.java.bean.Employees;
import com.java.service.EmployeeDAOImpl;
import com.java.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-08 10:43
 */
public class EmployeeDAOTest {

    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    @Test
    public void testGetAll() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        List<Employees> allEmployees = employeeDAO.getAllEmployees(connection);

        allEmployees.forEach(System.out::println);


    }

    @Test
    public void testInsert() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        Employees e = new Employees(14, "小白", 12,
                20000.0, "架构师", "Free",
                4000, 5000, "苹果电脑", "苹果显示器");


        int i = employeeDAO.insertEmployee(connection, e);

        System.out.println(i);


    }

    @Test
    public void testDeleteId() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        int i = employeeDAO.deleteEmployee(connection, 14);

        System.out.println(i);

    }

    @Test
    public void testgetEmployeesId() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        Employees employeesId = employeeDAO.getEmployeesId(connection, 13);

        System.out.println(employeesId);


    }

    @Test
    public void testupdateEmployee() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        Employees e = new Employees("小红", 12,
                20000.0, "架构师", "Free",
                4000, 5000, "苹果电脑", "苹果显示器");

        int i = employeeDAO.updateEmployee(connection, e, 13);
        System.out.println(i);

    }

    @Test
    public void testUpdateStatu() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        int busy = employeeDAO.updateStatus(connection, "FREE", 13);

        System.out.println(busy);


    }

    @Test
    public void testgetTeamCount() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        Long teamCount = employeeDAO.getTeamCount(connection, "架构师");

        System.out.println(teamCount);


    }

}
