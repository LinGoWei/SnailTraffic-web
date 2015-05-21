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
        // ʹ��Properties�������������ļ�
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
        // ��������
        Class.forName(driver);
        System.out.println("��ʼ�����������ݿ⣡");
    }
    
    public void insertUsePrepare()throws Exception
    {
        try(
            // ��ȡ���ݿ�����
            Connection conn = DriverManager.getConnection(url, user, pass);
            // ʹ��Connection������һ��PreparedStatement����
            PreparedStatement pstmt = conn.prepareStatement("insert into SITEINFO(sid,sname) values(?,?)")
           ){
        	System.out.println("�ɹ��������ݿ⣡");
            // 100��ΪPreparedStatement�Ĳ�����ֵ���Ϳ��Բ���100����¼
            for (int i = 0; i < 1000 ; i++ )
            {
            	pstmt.setInt(1, i);
            	pstmt.setString(2 , "����" + i);
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