package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * վ��������
 * @author weiliu
 */
public class AdminSiteTable extends AdminTableBase {
	
	public AdminSiteTable(Connection con) {
		this.con = con;	// ���ݿ����ӳ�Ա������ʼ��
		
		initPreparedStatement();
	}
	
	/**
	 * ��ʼ��Ԥ�������
	 */
	protected void initPreparedStatement() {
		try {
			String insertsql = "insert into SITEINFO(sid,sname) values(?,?)";
			
			String updatesql = "update SITEINFO SET sname = ? WHERE sname = ?";
			
			String deletesql = "delete FROM SITEINFO WHERE sname = ?";
			
			preinsert = con.prepareStatement(insertsql);
			
			preupdate = con.prepareStatement(updatesql);
			
			predelete = con.prepareStatement(deletesql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����վ����Ϣ
	 * @param sid
	 * 			վ��id
	 * @param sitename
	 * 			վ����
	 */
	public  void addSiteInfo(int sid, String sitename) {
		try {
			preinsert.setInt(1, sid);
		
			preinsert.setString(2, sitename);
			
			preinsert.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
