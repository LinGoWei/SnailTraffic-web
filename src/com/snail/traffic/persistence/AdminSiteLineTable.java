package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminSiteLineTable extends AdminTableBase {
	
	protected static PreparedStatement pre_updateL = null;	// ��������Ԥ����
	protected static PreparedStatement pre_updateR = null;	// ��������Ԥ����
	
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
			
			pre_insert = con.prepareStatement(insertsql);			
			pre_update = con.prepareStatement(updateLRlidseq);			
			pre_updateL = con.prepareStatement(updateLlidseq);			
			pre_updateR = con.prepareStatement(updateRlidseq);		
			pre_delete = con.prepareStatement(deletesql);
		
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
			pre_insert.setInt(1, lid);
			
			pre_insert.setString(2, Llidseq);
			
			pre_insert.setString(3, Rlidseq);
			
			pre_insert.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
