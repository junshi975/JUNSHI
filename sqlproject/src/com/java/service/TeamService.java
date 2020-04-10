package com.java.service;

import com.java.bean.Employees;
import com.java.bean.Team;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-08 19:07
 */
public class TeamService {

    EmployeeDAOImpl emDao = new EmployeeDAOImpl();
    TeamDAOImpl teamDAO = new TeamDAOImpl();

    /**
     * 获得所有员工
     *
     * @param conn
     * @return
     * @throws SQLException
     */
    public List<Employees> getAllEmployees(Connection conn) throws SQLException {

        List<Employees> allEmployees = emDao.getAllEmployees(conn);

        return allEmployees;
    }

    /**
     * 获取指定ID员工
     *
     * @param conn
     * @param id
     * @return
     */
    public Employees getEmployee(Connection conn, int id) {

        Employees employees = emDao.getEmployeesId(conn, id);

        return employees;
    }

    /**
     * 获得团队所有人
     *
     * @param conn
     * @return
     */
    public List<Team> getAllTeam(Connection conn) {


        List<Team> allTeam = teamDAO.getAllTeam(conn);

        return allTeam;
    }

    /**
     * 判断员工是否在团队中
     *
     * @param conn
     * @param employeeId
     * @return
     */
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

    /**
     * 向团队中删除成员
     *
     * @param TID
     */
    public void removeMember(Connection conn, int TID) throws TeamException {

        List<Team> allTeam = getAllTeam(conn);//先获得全体成员

        Iterator<Team> iterator = allTeam.iterator();

        while (iterator.hasNext()) {//遍历团队的成员寻找(若删除了，需要修改成员状态)
            Team team = iterator.next();//1,2,3,4,5.....
            // 如果团队中TID = 需要删除的ID

            if (team.getTID() == TID) {//如果团队中TID = 输入要删除的TID
                emDao.updateStatus(conn, "FREE", teamDAO.getTeamTId(conn, TID).getID());//设为FREE
                break;
            }

        }

        int deleteCount = teamDAO.deleteTeamMamberTID(conn, TID);//删除员工

        if (deleteCount == 0) {//如果删除的影响条数=0那么没删除到
            throw new TeamException("找不到指定memberId的员工，删除失败!");

        }

    }

    /**
     * 向团队中增添成员
     *
     * @param id
     */
    public void addMember(Connection conn, int id) throws TeamException {

        //公司没有可招用的员工
//        if (total >= team.length) {
//            throw new TeamException("添加失败,团队成员已满！");
//        }

//        该成员不是开发人员，无法添加
        Employees employee = getEmployee(conn, id);
        String position = employee.getPosition();
        if (!("程序员".equals(position) || "设计师".equals(position) || "架构师".equals(position))) {
            throw new TeamException("该成员不是开发人员，无法添加！");
        }


//		该员工已是某团队成员
        //员工在休假
        String status = employee.getStatus();
        if ("BUSY".equals(status)) {
            throw new TeamException("该员工已是某团队成员 !");
        } else if ("VOCATION".equals(status)) {
            throw new TeamException("该员正在休假，无法添加!");
            //如果他状态不是FREE或VOCATION或BUSY的情况
        } else if (!("BUSY".equals(status) || "VOCATION".equals(status)) && !("FREE".equals(status))) {
            throw new TeamException("该员状态异常，无法添加!");
        }

// 		团队中至多只能有一名架构师
//		团队中至多只能有两名设计师
//		团队中至多只能有三名程序员

        // 获取team中已有架构师，设计师，程序员的人数
        List<Team> allTeam = teamDAO.getAllTeam(conn);
        Long numOfArc = teamDAO.getTeamCount(conn, "架构师");
        Long numOfDes = teamDAO.getTeamCount(conn, "设计师");
        Long numOfPro = teamDAO.getTeamCount(conn, "程序员");

        Employees em = emDao.getEmployeesId(conn, id);
        String emPosition = em.getPosition();
        if ("程序员".equals(emPosition)) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员!");
            }
        } else if ("设计师".equals(emPosition)) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师！");
            }
        } else if ("架构师".equals(emPosition)) {
            if (numOfArc >= 1) {
                throw new TeamException("团队中至多只能有一名架构师！");
            }
        }

        int insertCount = teamDAO.insertTeam(conn, id);

        emDao.updateStatus(conn, "BUSY", id);// 更改状态

        if (insertCount == 0) {//如果删除的影响条数=0那么没删除到
            throw new TeamException("找不到指定memberId的员工，删除失败!");

        }

    }


}
