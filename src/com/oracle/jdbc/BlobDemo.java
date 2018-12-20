package com.oracle.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class BlobDemo {

    public static void main(String[] args) {

        Connection con=null;
        PreparedStatement sta=null;
        ResultSet rs=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection("jdbc:oracle:thin:@172.19.22.104:1521:XE","store","ok");
            sta=con.prepareStatement("insert into MEDIAS values(seq_medias.nextval,'¸ãÐ¦ÊÓÆµ',sysdate,?) ");

            FileInputStream  inputStream=new FileInputStream(new File("source/JDBCµÚÒ»ÕÂ¼ò½é.mp4"));
            sta.setBinaryStream(1,inputStream);

           int result= sta.executeUpdate();
            System.out.println(result>0?"insert success":"insert fail");
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
