package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 线路表管理类
 * @author weiliu
 *
 */
public class AdminLineTable extends AdminTableBase {
	
	/**
	 * 构造函数
	 * @param con
	 * 			数据库连接
	 */
	public AdminLineTable(Connection con) {
		this.con = con;	// 数据库连接成员变量初始化
		
		initPreparedStatement();
	}
	
	/**
	 * 初始化预编译语句
	 */
	protected void initPreparedStatement() {
		try {
			String insertsql = "insert into LINEINFO values(?,?,?,?,?,?,?,?,?,?)";
			
			String updatesql = "update LINEINFO SET sname=?,linterval=?,lfirstopen=?"
							+ ",llastopen=?,lfirstclose=?,llastclose=?,lprice=?,lcardprice=?,lcompany=?"
							+ "WHERE sname = ?";
			
			String deletesql = "delete FROM LINEINFO WHERE sname = ?";
			
			preinsert = con.prepareStatement(insertsql);
			
			preupdate = con.prepareStatement(updatesql);
			
			predelete = con.prepareStatement(deletesql);
		
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
	 * @param linterval
	 * 			线路区间
	 * @param lfirstopen
	 * 			首站开出时间
	 * @param llastopen
	 * 			末站开出时间
	 * @param lfirstclose
	 * 			首站结束时间
	 * @param llastclose
	 * 			末站结束时间
	 * @param lprice
	 * 			价格
	 * @param lcardprice
	 * 			刷卡价格
	 * @param lcompany
	 * 			所属公司
	 */
	public void addLineInfo(int sid
							, String sitename
							, String linterval
							, String lfirstopen
							, String llastopen
							, String lfirstclose
							, String llastclose
							, String lprice
							, String lcardprice
							, String lcompany){
		try {
			preinsert.setInt(1, sid);
			preinsert.setString(2, sitename);
			preinsert.setString(3, linterval);
			preinsert.setString(4, lfirstopen);
			preinsert.setString(5, llastopen);
			preinsert.setString(6, lfirstclose);
			preinsert.setString(7, llastclose);
			preinsert.setString(8, lprice);
			preinsert.setString(9, lcardprice);
			preinsert.setString(10, lcompany);
			preinsert.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
