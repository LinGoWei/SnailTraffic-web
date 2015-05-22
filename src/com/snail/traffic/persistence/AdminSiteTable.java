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
			
			pre_insert = con.prepareStatement(insertsql);	
			pre_update = con.prepareStatement(updatesql);		
			pre_delete = con.prepareStatement(deletesql);		
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
			pre_insert.setInt(1, sid);	
			pre_insert.setString(2, sitename);			
			pre_insert.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}