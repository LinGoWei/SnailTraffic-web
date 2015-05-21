package com.snail.traffic.persistence;



import java.util.*;
import java.io.*;
import java.sql.*;

public class PreparedStatementTest{
    private String driver;
    private String url;
    private String user;
    private String pass;
    
    public void initParam(String paramFile)throws Exception
    {
        // 使用Properties类来加载属性文件
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
        // 加载驱动
        Class.forName(driver);
        System.out.println("开始尝试连接数据库！");
    }
    
    public void insertUsePrepare()throws Exception
    {
        try(
            // 获取数据库连接
            Connection conn = DriverManager.getConnection(url, user, pass);
            // 使用Connection来创建一个PreparedStatement对象
            PreparedStatement pstmt = conn.prepareStatement("insert into SITEINFO(sid,sname) values(?,?)")
           ){
        	System.out.println("成功连接数据库！");
            // 100次为PreparedStatement的参数设值，就可以插入100条记录
            for (int i = 0; i < 1000 ; i++ )
            {
            	pstmt.setInt(1, i);
            	pstmt.setString(2 , "姓名" + i);
            	pstmt.executeUpdate();
            }
        }
    }
    
    public static void main(String[] args) throws Exception
    {
        PreparedStatementTest pt = new PreparedStatementTest();
        pt.initParam("oracle.ini");
        pt.insertUsePrepare();
    }
}