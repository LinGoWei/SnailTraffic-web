package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ��·�������
 * @author weiliu
 *
 */
public class AdminLineTable extends AdminTableBase {
	
	/**
	 * ���캯��
	 * @param con
	 * 			���ݿ�����
	 */
	public AdminLineTable(Connection con) {
		this.con = con;	// ���ݿ����ӳ�Ա������ʼ��
		
		initPreparedStatement();
	}
	
	/**
	 * ��ʼ��Ԥ�������
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
	 * ����վ����Ϣ
	 * @param sid
	 * 			վ��id
	 * @param sitename
	 * 			վ����
	 * @param linterval
	 * 			��·����
	 * @param lfirstopen
	 * 			��վ����ʱ��
	 * @param llastopen
	 * 			ĩվ����ʱ��
	 * @param lfirstclose
	 * 			��վ����ʱ��
	 * @param llastclose
	 * 			ĩվ����ʱ��
	 * @param lprice
	 * 			�۸�
	 * @param lcardprice
	 * 			ˢ���۸�
	 * @param lcompany
	 * 			������˾
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
