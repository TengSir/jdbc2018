package com.oracle.jdbc;

import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) {

        Connection con=null;
        PreparedStatement sta=null;
        ResultSet rs=null;
        try {
             Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection("jdbc:oracle:thin:@172.19.22.104:1521:XE","store","ok");
            sta=con.prepareStatement("select * from stus where stuid=? and stuname=? ");

            //预处理会话注入参数
            sta.setInt(1,3243);
            sta.setString(2,"Abel Wolf");
            rs=sta.executeQuery();
            while(rs.next()){
                System.out.println("name:"+rs.getString("stuName")+",sex:"+rs.getString("stusex")+",age:"+rs.getInt("stuage"));
            }

            sta.setInt(1,433);
            sta.setString(2,"Abigail Barrett");
            rs=sta.executeQuery();
            while(rs.next()){
                System.out.println("name:"+rs.getString("stuName")+",sex:"+rs.getString("stusex")+",age:"+rs.getInt("stuage"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(sta!=null) {
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
