package com.java.test;

import com.java.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-07 21:07
 */
public class ConnectionTest {

    @Test
    public void testConnection() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        System.out.println(connection);

        JDBCUtils.closeResource(connection);


    }

    @Test
    public void testInsert() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            QueryRunner queryRunner = new QueryRunner();

            String sql = "INSERT INTO team(name)VALUES(?)";
            for (int i = 0; i < 10; i++) {
                queryRunner.update(connection, sql, i);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection);
        }


    }
}
