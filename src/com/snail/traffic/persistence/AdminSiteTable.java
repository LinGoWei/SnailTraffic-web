package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 站点表管理类
 * @author weiliu
 */
public class AdminSiteTable extends AdminTableBase {
	
	public AdminSiteTable(Connection con) {
		this.con = con;	// 数据库连接成员变量初始化
		initPreparedStatement();
	}
	
	/**
	 * 初始化预编译语句
	 */
	protected void initPreparedStatement() {
		try {
			String insertsql = "insert into SITEINFO(sid,sname) values(?,?)";		
			String updatesql = "update SITEINFO SET sname = ? WHERE sname = ?";		
			String deletesql = "delete FROM SITEINFO WHERE sname = ?";
			
			pre_insert = con.prepareStatement(insertsql);	
			pre_update = con.prepareStatement(updatesql);		
			pre_delete = con.prepareStatement(deletesql);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 增加站点信息
	 * @param sid
	 * 			站点id
	 * @param sitename
	 * 			站点名
	 */
	public  void addSiteInfo(int sid, String sitename) {
		try {
			pre_insert.setInt(1, sid);	
			pre_insert.setString(2, sitename);			
			pre_insert.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}