package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 线路站点表管理类
 * @author weiliu
 */
public class AdminLineSiteTable extends AdminTableBase {
	
	/**
	 * 构造函数
	 * @param con
	 * 			数据库连接
	 */
	public AdminLineSiteTable(Connection con) {
		this.con = con;	// 数据库连接成员变量初始化	
		initPreparedStatement();	// 初始化预编译语句
	}
	
	/**
	 * 初始化预编译语句
	 */
	protected void initPreparedStatement() {
		try {
			String insertsql = "insert into LINETOSITE values(?,?,?)";
			String updateLRsidseq = "update LINETOSITE SET lsidseq=?, rsidseq=? WHERE lid = ?";			
			String updateLsidseq = "update LINETOSITE SET lsidseq=? WHERE lid = ?";			
			String updateRsidseq = "update LINETOSITE SET rsidseq=? WHERE lid = ?";		
			String deletesql = "delete FROM LINETOSITE WHERE lid = ?";
			
			pre_insert = con.prepareStatement(insertsql);			
			pre_update = con.prepareStatement(updateLRsidseq);			
			pre_update = con.prepareStatement(updateLsidseq);			
			pre_update = con.prepareStatement(updateRsidseq);			
			pre_delete = con.prepareStatement(deletesql);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 向线路站点表中添加一个记录
	 * @param lid
	 * 			线路id
	 * @param lsidseq
	 * 			左行站点集合
	 * @param rsidseq
	 * 			右行站点集合
	 */
	public void addLineToSite(int lid, String lsidseq, String rsidseq) {
		try {
			pre_insert.setInt(1, lid);		
			pre_insert.setString(2, lsidseq);			
			pre_insert.setString(3, rsidseq);			
			pre_insert.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
