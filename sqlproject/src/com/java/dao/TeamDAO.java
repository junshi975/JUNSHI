package com.java.dao;

import com.java.bean.Employees;
import com.java.bean.Team;
import com.java.service.TeamException;

import java.sql.Connection;
import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-07 23:23
 */
public interface TeamDAO {

    /**
     * 获得整个团队的成员记录(团队页面）
     * 用于view开始页面显示全部员工信息
     *
     * @param conn
     * @return
     */
    List<Team> getAllTeam(Connection conn);

    /**
     * 从Employees插入一个员工去team（添加团队成员）
     *
     * @param conn
     * @param employeeId
     */
    int insertTeam(Connection conn, int employeeId) throws TeamException;

    /**
     * 删除指定TID的团队列表成员
     *
     * @param conn
     * @param TID
     */
    int deleteTeamMamberTID(Connection conn, int TID);

    /**
     * 根据员工TID获得一条员工信息（获得一条团队成员的信息）
     *
     * @param conn
     * @param TID
     * @return
     */
    Team getTeamTId(Connection conn, int TID);

    /**
     * 根据员工id更新员工的信息（更新团队成员的信息）
     *
     * @param conn
     * @param team
     */
    int updateTeam(Connection conn, Team team, int TID);

    /**
     * 删除所有团队员工（删除所有团队成员）
     *
     * @param conn
     */
    int deleteAllTeam(Connection conn);

    /**
     * 获得团队人数
     *
     * @param conn
     * @return
     */
    Long getCount(Connection conn);

    /**
     * 获取指定职位名的员工个数，用于判断插入
     *
     * @param conn
     * @param position
     * @return
     */
    Long getTeamCount(Connection conn, String position);

    /**
     * 判断员工是否存在数据库内
     *
     * @param employeeId
     * @return
     */
    boolean isExist(Connection conn, int employeeId);

}
