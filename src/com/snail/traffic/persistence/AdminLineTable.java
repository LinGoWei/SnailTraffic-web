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
			String deletesql = "delete FROM LINEINFO WHERE sname = ?";
			String updatesql = "update LINEINFO SET sname=?,linterval=?,lfirstopen=?"
							+ ",llastopen=?,lfirstclose=?,llastclose=?,lprice=?,lcardprice=?,lcompany=?"
							+ "WHERE sname = ?";

			pre_insert = con.prepareStatement(insertsql);			
			pre_update = con.prepareStatement(updatesql);			
			pre_delete = con.prepareStatement(deletesql);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 增加线路信息
	 * @param lid
	 * 			线路id
	 * @param linename
	 * 			线路名
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
	public void addLineInfo(int lid
							, String linename
							, String linterval
							, String lfirstopen
							, String llastopen
							, String lfirstclose
							, String llastclose
							, String lprice
							, String lcardprice
							, String lcompany) {
		try {
			pre_insert.setInt(1, lid);
			pre_insert.setString(2, linename);
			pre_insert.setString(3, linterval);
			pre_insert.setString(4, lfirstopen);
			pre_insert.setString(5, llastopen);
			pre_insert.setString(6, lfirstclose);
			pre_insert.setString(7, llastclose);
			pre_insert.setString(8, lprice);
			pre_insert.setString(9, lcardprice);
			pre_insert.setString(10, lcompany);
			pre_insert.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
