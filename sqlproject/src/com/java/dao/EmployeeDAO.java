package com.java.dao;

import com.java.bean.Employees;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-07 23:00
 */
public interface EmployeeDAO {

    /**
     * 获得整个团队的成员记录(开始页面)
     * 用于view开始页面显示全部员工信息
     *
     * @param conn
     * @return
     */
    List<Employees> getAllEmployees(Connection conn) throws SQLException;

    /**
     * 插入一个员工(添加到主页面列表)
     *
     * @param conn
     * @param em
     */
    int insertEmployee(Connection conn, Employees em);

    /**
     * （删除主页面指定id员工）
     *
     * @param conn
     * @param ID
     */
    int deleteEmployee(Connection conn, int ID);

    /**
     * 根据员工id获得一条员工信息(得到一个employee的信息)
     *
     * @param conn
     * @param id
     * @return
     */
    Employees getEmployeesId(Connection conn, int id);

    /**
     * 根据指定员工id更新员工信息
     * @param conn
     * @param em
     */
    int updateEmployee(Connection conn, Employees em, int id);

    /**
     * 获得员工总人数
     * @param conn
     * @return
     */
    Long getTeamCount(Connection conn);

    /**
     * 获取指定职位名的员工个数，用于判断插入
     *
     * @param conn
     * @param position
     * @return
     */
    Long getTeamCount(Connection conn, String position);

    /**
     * 修改指定ID员工的状态
     *
     * @param conn
     * @param id
     * @return
     */
    int updateStatus(Connection conn, String status, int id);


}
