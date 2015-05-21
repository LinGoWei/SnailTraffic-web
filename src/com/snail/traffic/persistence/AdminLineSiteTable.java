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
		
		initPreparedStatement();
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
			
			preinsert = con.prepareStatement(insertsql);
			
			preupdate = con.prepareStatement(updateLRsidseq);
			
			preupdate = con.prepareStatement(updateLsidseq);
			
			preupdate = con.prepareStatement(updateRsidseq);
			
			predelete = con.prepareStatement(deletesql);
			
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
			preinsert.setInt(1, lid);
			
			preinsert.setString(2, lsidseq);
			
			preinsert.setString(3, rsidseq);
			
			preinsert.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
