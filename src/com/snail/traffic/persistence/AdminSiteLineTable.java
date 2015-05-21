package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminSiteLineTable extends AdminTableBase {
	
	protected static PreparedStatement preupdateL = null;	// ��������Ԥ����
	
	protected static PreparedStatement preupdateR = null;	// ��������Ԥ����
	
	/**
	 * ���캯��
	 * @param con
	 * 			���ݿ�����
	 */
	public AdminSiteLineTable(Connection con) {
		this.con = con;	// ���ݿ����ӳ�Ա������ʼ��
		
		initPreparedStatement();
	}
	
	/**
	 * ��ʼ��Ԥ�������
	 */
	protected void initPreparedStatement() {
		try {
			String insertsql = "insert into SITETOLINE values(?,?,?)";
			
			String updateLRlidseq = "update SITETOLINE SET LLidseq=?, RLidseq=? WHERE sid = ?";
			
			String updateLlidseq = "update SITETOLINE SET LLidseq=? WHERE sid = ?";
			
			String updateRlidseq = "update SITETOLINE SET RLidseq=? WHERE sid = ?";
			
			String deletesql = "delete FROM SITETOLINE WHERE sid = ?";
			
			preinsert = con.prepareStatement(insertsql);
			
			preupdate = con.prepareStatement(updateLRlidseq);
			
			preupdateL = con.prepareStatement(updateLlidseq);
			
			preupdateR = con.prepareStatement(updateRlidseq);
			
			predelete = con.prepareStatement(deletesql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �����ݿ�վ����·�������һ��վ����·��¼
	 * @param lid
	 * 			վ��id
	 * @param Llidseq
	 * 			������·id����
	 * @param Rlidseq
	 * 			������·id����
	 */
	public void addSiteToLine(int lid, String Llidseq, String Rlidseq) {
		try {	
			preinsert.setInt(1, lid);
			
			preinsert.setString(2, Llidseq);
			
			preinsert.setString(3, Rlidseq);
			
			preinsert.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
