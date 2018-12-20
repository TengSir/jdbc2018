package com.oracle.jdbc;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) {
        int yourInputUserid=222;
        String username="admin";
        Connection con=null;
        Statement  sta=null;
        ResultSet  rs=null;
        try {
            //1.加载驱动（第三方），jdk1.6以前必须手动装载驱动，1。6以后驱动会自动被装载
           // Class.forName("oracle.jdbc.driver.OracleDriver");

            //2.建立链接，使用jdbc api中提供的驱动管理器打开一个链接
            con= DriverManager.getConnection("jdbc:oracle:thin:@172.19.22.104:1521:XE","store","ok");

            //3.在链接的基础上建立会话（Statement）
              sta=con.createStatement();//会话必须在链接的基础上创建

            //4.使用会话对象向数据库发出数据操作的标注指令（SQL语句）
            String sql="select * from stus where name='"+username+"'";
              rs=sta.executeQuery(sql);

            //5当sql语句执行完成后就可以对操作完成对数据进行业务操作（如果是查询，我们就需要解析结果集）
            while(rs.next()){
                System.out.print(rs.getString("stuname")+"----");;
                System.out.println(rs.getInt(4));
            }

//           int result= sta.executeUpdate("delete  from  stus where stuid=2396");
//            System.out.println(result>0?"删除成功":"删除失败");
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
