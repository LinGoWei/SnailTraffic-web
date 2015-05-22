package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.snail.traffic.control.ArrayStruct;

/**
 * ��ѯ���ݿ���
 * 
 * ������ֻ������������ݿ��Ĳ�ѯ����ͼ��ѯ
 * 
 * ֻ��Ҫ����ò�ѯ��API,���ڲ�ѯ���ʲô�ã���ѯ��õ�ʲô��ʽ
 * 
 * �Ҷ����ܣ�������
 * 
 * @author weiliu
 *
 */
public class SelectOperated {
	private Connection con = null;	// �������ݿ�����
	
	private PreparedStatement pre_viewSiteLine = null;	// ��ѯվ����·��ͼԤ����
	private PreparedStatement pre_viewLineSite = null;	// ��ѯ��·վ����ͼԤ����
	
	private PreparedStatement pre_tableLineName = null;	// ��ѯ��·��Ԥ����
	private PreparedStatement pre_tableSiteName = null;	// ��ѯվ����Ԥ����
	
	private PreparedStatement pre_tableLineInfo = null;	// ��ѯ��·��Ϣ��Ԥ����	
	
	public SelectOperated(Connection con) {
		this.con = con;
		initPreparedStatement();	// ��ʼ��Ԥ����
	}
	
	/**
	 * ��ʼ��Ԥ�������
	 */
	private void initPreparedStatement() {
		try {
			String viewSiteLine = "SELECT llidseq, rlidseq FROM��View_SiteLine�� WHERE sname = ?";	
			String viewLineSite = "SELECT lsidseq, rsidseq FROM��View_LineSite�� WHERE lname = ?";
			
			String tableLineName = "SELECT lname FROM��LineInfo�� WHERE lid = ?";
			String tableSiteName = "SELECT sname FROM��SiteInfo�� WHERE sid = ?";

			String tableLineInfo = "SELECT lname, LINTERVAL"
									+ ", LFIRSTOPEN, LLASTOPEN, LFIRSTCLOSE, LLASTCLOSE"
									+ ", LPRICE, LCARDPRICE, LCOMPANY"
									+ " FROM��LineInfo"
									+ " WHERE lname = ?";
			
			pre_viewSiteLine = con.prepareStatement(viewSiteLine);
			pre_viewLineSite = con.prepareStatement(viewLineSite);
			
			pre_tableLineName = con.prepareStatement(tableLineName);
			pre_tableSiteName = con.prepareStatement(tableSiteName);
			
			pre_tableLineInfo = con.prepareStatement(tableLineInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * ��ȡ����������վ����·�����ַ���API
	 * @param sitename
	 * 				վ����
	 * @return siteline
	 * 				վ����·ö��map(������ߣ��ұ�)
	 */
	public TwoLongStruct getSiteLineSeq(String sitename) {
		
		TwoLongStruct siteline = new TwoLongStruct();	// ����վ����·�����ַ���
		
		try {
			pre_viewSiteLine.setString(1, sitename);
			
			ResultSet rs = pre_viewSiteLine.executeQuery();
			
			if(rs.next()) {
				siteline.put(true, rs.getString(1));	// ���������·�����ַ���
				siteline.put(false, rs.getString(2));	// �����ұ���·�����ַ���
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return siteline;
	}
	
	/**
	 * ��ȡ��·վ�������վ����������������վ����������
	 * @param lname
	 * 			��·��
	 * @return linesite
	 * 				��·վ��ö��map����ߡ��ұߣ�
	 */
	public TwoLongStruct getLineSiteSeq(String lname) {
		
		TwoLongStruct linesite = new TwoLongStruct();	// ��ȡ����վ����·�����ַ���
		
		try {
			pre_viewLineSite.setString(1, lname);
			
			ResultSet rs = pre_viewLineSite.executeQuery();
			
			if (rs.next()) {
				linesite.put(true, rs.getString(1));	// �������վ�㼯���ַ���
				linesite.put(false, rs.getString(2));	// �����ұ�վ�㼯���ַ���
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return linesite;
	}

	/**
	 * ��ȡ��·��Ϣ
	 * @param linename
	 * @return
	 */
	public ArrayStruct getLineInfo(String linename) {
		ArrayStruct lineinfo = new ArrayStruct();
		
		try {
			pre_tableLineInfo.setString(1, linename);	// ���ò���
			
			ResultSet rs = pre_tableLineInfo.executeQuery();
			
			if(rs.next()) {
				lineinfo.setLine(rs.getString(1), rs.getString(2));
				lineinfo.setTime(rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				lineinfo.setPrice(rs.getString(7), rs.getString(8));
				lineinfo.setCompany(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lineinfo;
	}
	
	/**
	 * ͨ����·id�����·��
	 * 
	 * @param lid
	 * 			������·id
	 * @return linename
	 */
	public String getLineName(int lid) {
		String linename = null;	// ��·��
		
		try {
			pre_tableLineName.setInt(1, lid);	// ���ò���
			
			ResultSet rs = pre_tableLineName.executeQuery();
			
			if(rs.next())
				linename = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linename;	
	}
	
	/**
	 * ���ȼ�Ϊ2
	 * ͨ��վ��id���վ����
	 * @param sid
	 * 			վ��id
	 * @return sitename
	 * 				վ����
	 */
	public String getSiteName(int sid) {
		String sitename = null;	// վ����
		try {
			pre_tableSiteName.setInt(1, sid);	// ���ò���
			
			ResultSet rs = pre_tableSiteName.executeQuery();
			
			if(rs.next())
				sitename = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sitename;
	}
}
