package com.java.view;

import com.java.bean.Employees;
import com.java.bean.Team;
import com.java.service.EmployeeDAOImpl;
import com.java.service.TeamDAOImpl;
import com.java.service.TeamException;
import com.java.service.TeamService;
import com.java.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class TeamView {
    TeamService tS = new TeamService();
    EmployeeDAOImpl eDao = new EmployeeDAOImpl();
    TeamDAOImpl tDao = new TeamDAOImpl();

    public void enterMainMenu() throws SQLException, TeamException {


        boolean loopFlag = true;
        char key = 0;

        do {
            if (key != '1') {
                listAllEmployees();
            }
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            key = TSUtility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    listTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    char yn = TSUtility.readConfirmSelection();
                    if (yn == 'Y')
                        loopFlag = false;
                    break;
            }
        } while (loopFlag);
    }

    // 显示所有的员工成员
    private void listAllEmployees() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        System.out
                .println("\n-------------------------------开发团队调度软件--------------------------------\n");

        Long count = eDao.getTeamCount(connection);

        if (count == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("ID\t姓名" + "\t年龄\t工资\t职位\t状态\t奖金\t" + " 股票\t\t领用设备");
        }
        List<Employees> allEmployees = eDao.getAllEmployees(connection);


        Iterator<Employees> iterator = allEmployees.iterator();

        while (iterator.hasNext()) {

            Employees e = iterator.next();

            System.out.println(e.toString());

        }
        JDBCUtils.closeResource(connection);
        System.out
                .println("-------------------------------------------------------------------------------");
    }

    // 显示开发团队成员列表
    private void listTeam() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        System.out
                .println("\n--------------------团队成员列表---------------------\n");
        System.out.println("TID/ID\t\t姓名\t年龄\t工资\t职位\t奖金\t股票");
        List<Team> allTeam = tDao.getAllTeam(connection);

        Iterator<Team> iterator = allTeam.iterator();

        while (iterator.hasNext()) {
            Team team = iterator.next();

            System.out.println(team);
        }

        JDBCUtils.closeResource(connection);
        System.out
                .println("-----------------------------------------------------");
    }

    // 添加成员到团队
    private void addMember() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        System.out.println("---------------------添加成员---------------------");

        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();

        try {
            tS.addMember(connection, id);
            System.out.println("添加成功！");
        } catch (TeamException e) {
            System.out.println("添加失败，原因是：" + e.getMessage());
        }

        // 按回车键继续...
        TSUtility.readReturn();
    }

    // 从团队中删除指定id的成员
    private void deleteMember() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        System.out.println("---------------------删除成员---------------------");

        System.out.print("请输入要删除员工的TID：");

        int TID = TSUtility.readInt();//输入的指定TID

        System.out.print("确认是否删除(Y/N)：");
        char isflag = TSUtility.readConfirmSelection();
        if (isflag == 'N') {
            return;
        }

        try {
            tS.removeMember(connection, TID);//删除指定TID的成员
        } catch (TeamException e) {
            System.out.println("删除失败，原因是：" + e.getMessage());
        }

        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        try {
            view.enterMainMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
