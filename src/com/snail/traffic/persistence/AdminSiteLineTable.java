package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminSiteLineTable extends AdminTableBase {
	
	protected static PreparedStatement pre_updateL = null;	// 更新数据预编译
	protected static PreparedStatement pre_updateR = null;	// 更新数据预编译
	
	/**
	 * 构造函数
	 * @param con
	 * 			数据库连接
	 */
	public AdminSiteLineTable(Connection con) {
		this.con = con;	// 数据库连接成员变量初始化		
		initPreparedStatement();
	}
	
	/**
	 * 初始化预编译语句
	 */
	protected void initPreparedStatement() {
		try {
			String insertsql = "insert into SITETOLINE values(?,?,?)";			
			String updateLRlidseq = "update SITETOLINE SET LLidseq=?, RLidseq=? WHERE sid = ?";			
			String updateLlidseq = "update SITETOLINE SET LLidseq=? WHERE sid = ?";			
			String updateRlidseq = "update SITETOLINE SET RLidseq=? WHERE sid = ?";			
			String deletesql = "delete FROM SITETOLINE WHERE sid = ?";
			
			pre_insert = con.prepareStatement(insertsql);			
			pre_update = con.prepareStatement(updateLRlidseq);			
			pre_updateL = con.prepareStatement(updateLlidseq);			
			pre_updateR = con.prepareStatement(updateRlidseq);		
			pre_delete = con.prepareStatement(deletesql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 向数据库站点线路表中添加一行站点线路记录
	 * @param lid
	 * 			站点id
	 * @param Llidseq
	 * 			左行线路id集合
	 * @param Rlidseq
	 * 			右行线路id集合
	 */
	public void addSiteToLine(int lid, String Llidseq, String Rlidseq) {
		try {	
			pre_insert.setInt(1, lid);
			
			pre_insert.setString(2, Llidseq);
			
			pre_insert.setString(3, Rlidseq);
			
			pre_insert.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
