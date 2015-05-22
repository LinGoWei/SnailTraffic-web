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
	 * ������·��Ϣ
	 * @param lid
	 * 			��·id
	 * @param linename
	 * 			��·��
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
