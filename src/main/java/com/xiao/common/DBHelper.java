package com.xiao.common;

import org.junit.Test;

import java.sql.*;

/**
 * Created by knight on 16/12/12.
 */
public class DBHelper {


    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/ShanXiShenBao?"
                + "user=root&password=hblgdx703ys&useUnicode=true&characterEncoding=UTF8";
        try {

            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            System.out.println("成功加载MySQL驱动程序");
            if (null == conn) {
                conn = DriverManager.getConnection(url);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 释放【ResultSet】资源
     *
     * @param rs
     */
    public static void free(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

    /**
     * 释放【Statement】资源
     *
     * @param st
     */
    public static void free(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

    /**
     * 释放【Connection】资源
     *
     * @param conn
     */
    public static void free(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }


    /**
     * 释放所有数据资源
     *
     * @param rs
     * @param st
     * @param conn
     */
    public static void free(ResultSet rs, Statement st, Connection conn) {
        free(rs);
        free(st);
        free(conn);
    }

    /**
     * 查【Query】
     *
     * @param sql
     * @return ResultSet
     */
    public static ResultSet executeQuery(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException err) {
            err.printStackTrace();
            free(rs, stmt, conn);
        }

        return rs;
    }

    /**
     * 查【Query】
     *
     * @param sql
     * @param obj 用来定义函数时,传的参数个数可以不确定.
     * @return ResultSet
     */
    public static ResultSet executeQuery(String sql, Object... obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            for (int i = 0; i < obj.length; i++) {
                pstmt.setObject(i + 1, obj[i]);
            }

            rs = pstmt.executeQuery();
        } catch (SQLException err) {
            err.printStackTrace();
            free(rs, pstmt, conn);
        }

        return rs;
    }


    /**
     * 增删改【Add、Del、Update】
     *
     * @param sql
     * @return int
     */
    public static int executeNonQuery(String sql) {
        int result = 0;
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException err) {
            err.printStackTrace();
            free(null, stmt, conn);
        } finally {
            free(null, stmt, conn);
        }

        return result;
    }

    /**
     * 增删改【Add、Delete、Update】
     *
     * @param sql
     * @param obj
     * @return int
     */
    public static int executeNonQuery(String sql, Object... obj) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            for (int i = 0; i < obj.length; i++) {
                pstmt.setObject(i + 1, obj[i]);
            }

            result = pstmt.executeUpdate();
        } catch (SQLException err) {
            err.printStackTrace();
            free(null, pstmt, conn);
        } finally {
            free(null, pstmt, conn);
        }
        return result;
    }

    /**
     * 判断记录是否存在
     *
     * @param sql
     * @return Boolean
     */
    public static Boolean isExist(String sql) {
        ResultSet rs = null;

        try {
            rs = executeQuery(sql);
            rs.last();
            int count = rs.getRow();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException err) {
            err.printStackTrace();
            free(rs);
            return false;
        } finally {
            free(rs);
        }
    }

    /**
     * 判断记录是否存在
     *
     * @param sql
     * @return Boolean
     */
    public static Boolean isExist(String sql, Object... obj) {
        ResultSet rs = null;

        try {
            rs = executeQuery(sql, obj);
            rs.last();
            int count = rs.getRow();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException err) {
            err.printStackTrace();
            free(rs);
            return false;
        } finally {
            free(rs);
        }
    }

    /**
     * 获取查询记录的总行数
     *
     * @param sql
     * @return int
     */
    public static int getCount(String sql) {
        int result = 0;
        ResultSet rs = null;

        try {
            rs = executeQuery(sql);
            rs.last();
            result = rs.getRow();
        } catch (SQLException err) {
            free(rs);
            err.printStackTrace();
        } finally {
            free(rs);
        }

        return result;
    }

    /**
     * 获取查询记录的总行数
     *
     * @param sql
     * @param obj
     * @return int
     */
    public static int getCount(String sql, Object... obj) {
        int result = 0;
        ResultSet rs = null;

        try {
            rs = executeQuery(sql, obj);
            rs.last();
            result = rs.getRow();
        } catch (SQLException err) {
            err.printStackTrace();
        } finally {
            free(rs);
        }

        return result;
    }


    @Test
    public void testQuery() {
//        //第一种情况
//        String sql1="Select * From TaxTypes";
//        //第一步：查询
//        ResultSet rs1 = DBHelper.executeQuery(sql1);
//        //第二步：输出
//        try {
//            while(rs1.next()){
//                System.out.println("名称："+rs1.getString(2));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        //第三步：关闭
//        DBHelper.free(rs1);
//
//        //第二种情况
//        String sql2="Select * From TaxTypes where ID=?";
//        Object[] obj = new Object[]{1};
//        //第一步：查询
//        ResultSet rs2 = DBHelper.executeQuery(sql2,obj);
//        //第二步：输出
//        try {
//            while(rs2.next()){
//                System.out.println("学号："+rs2.getString(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        //第三步：关闭
//        DBHelper.free(rs2);
    }


    @Test
    public void testAdd() {
        //第一种情况
        String sql1 = "INSERT INTO TaxTypes(NAME,CODE)VALUES('中国红','ChinaRed')";
        System.out.println(DBHelper.executeNonQuery(sql1));

        //第二种情况
//        String sql2="INSERT INTO TaxTypes(NAME,CODE)VALUES(?,?)";
//        Object[] obj = new Object[]{"金州勇士","库里"};
//        System.out.println(DBHelper.executeNonQuery(sql2,obj));
    }

    @Test
    public void testUpdate() {
        //第1种情况
//        String sql1 = "update TaxTypes set CODE='Warrior' where ID=6";
//        System.out.println(DBHelper.executeNonQuery(sql1));

        //第2种情况
        String sql2 = "update TaxTypes set CODE=? where ID=?";
        Object[] parapms = new Object[]{
                "GoldenState",
                6
        };
        System.out.println(DBHelper.executeNonQuery(sql2,parapms));
    }


    @Test
    public  void testDelete(){
        //第1种情况
        String sql1 ="delete from TaxTypes where ID=5";
//        System.out.println(DBHelper.executeNonQuery(sql1));

        //第2种情况
        String sql2 ="delete from TaxTypes where ID=?";
        Object[] params = new Object[]{
            4
        };
        System.out.println(DBHelper.executeNonQuery(sql2,params));
    }




}
