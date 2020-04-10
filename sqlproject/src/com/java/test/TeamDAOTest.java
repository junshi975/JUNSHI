package com.java.test;

import com.java.bean.Team;
import com.java.service.TeamDAOImpl;
import com.java.service.TeamException;
import com.java.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-08 13:01
 */
public class TeamDAOTest {

    TeamDAOImpl teamDAO = new TeamDAOImpl();

    @Test
    public void testGetAllTeam() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        List<Team> allTeam = teamDAO.getAllTeam(connection);

        allTeam.forEach(System.out::println);

    }

    @Test
    public void testInsertTeam() throws SQLException, TeamException {

        Connection connection = JDBCUtils.getConnection();

        int insertCount = teamDAO.insertTeam(connection, 13);

        System.out.println(insertCount);


    }

    @Test
    public void testDeleteTeamMamberTID() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        int i = teamDAO.deleteTeamMamberTID(connection, 1);
        System.out.println(i);

    }

    @Test
    public void testGetTeamTId() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        Team teamTId = teamDAO.getTeamTId(connection, 6);

        System.out.println(teamTId);


    }

    @Test
    public void testUpdateTeam() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        Team team = new Team(1, "小红", 13, 333, "傻逼", 233, 223);

        int i = teamDAO.updateTeam(connection, team, 1);

        System.out.println(i);

    }

    @Test
    public void testDeleteAllTeam() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        int i = teamDAO.deleteAllTeam(connection);
        System.out.println(i);

    }

    @Test
    public void testGetTeamCount() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        Long count = teamDAO.getTeamCount(connection, "傻逼");
        System.out.println(count);

    }

    @Test
    public void test() throws SQLException {
        Connection connection = JDBCUtils.getConnection();


    }
//test update
}
