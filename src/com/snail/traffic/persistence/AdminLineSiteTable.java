package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ��·վ��������
 * @author weiliu
 */
public class AdminLineSiteTable extends AdminTableBase {
	
	/**
	 * ���캯��
	 * @param con
	 * 			���ݿ�����
	 */
	public AdminLineSiteTable(Connection con) {
		this.con = con;	// ���ݿ����ӳ�Ա������ʼ��
		
		initPreparedStatement();
	}
	
	/**
	 * ��ʼ��Ԥ�������
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
	 * ����·վ��������һ����¼
	 * @param lid
	 * 			��·id
	 * @param lsidseq
	 * 			����վ�㼯��
	 * @param rsidseq
	 * 			����վ�㼯��
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
