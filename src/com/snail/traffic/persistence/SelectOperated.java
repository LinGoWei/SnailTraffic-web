package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumMap;

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
	
	private String leftSiteLine = null;		// վ������·����
	private String rightSiteLine = null;	// վ������·����
	private String leftSites = null;		// ��·����վ������
	private String rightSites = null;		// ��·����վ������
	
	
	public SelectOperated(Connection con){
		this.con = con;
		initPreparedStatement();	// ��ʼ��Ԥ����
	}
	
	/**
	 * ��ʼ��Ԥ�������
	 */
	private void initPreparedStatement(){
		try {
			String viewSiteLine = "SELECT llidseq, rlidseq FROM��View_SiteLine�� WHERE sname = ?";	
			String viewLineSite = "SELECT lsidseq, rsidseq FROM��View_LineSite�� WHERE lname = ?";
			
			String tableLineName = "SELECT lname FROM��LineInfo�� WHERE lid = ?";
			String tableSiteName = "SELECT sname FROM��SiteInfo�� WHERE sid = ?";

			pre_viewSiteLine = con.prepareStatement(viewSiteLine);
			pre_viewLineSite = con.prepareStatement(viewLineSite);
			
			pre_tableLineName = con.prepareStatement(tableLineName);
			pre_tableSiteName = con.prepareStatement(tableSiteName);

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
	public EnumMap<ListEnum,String> getSiteLineSeq(String sitename) {
		
		EnumMap<ListEnum,String> siteline = null;	// ����վ����·�����ַ���
		
		try {
			pre_viewSiteLine.setString(1, sitename);
			
			ResultSet rs = pre_viewSiteLine.executeQuery();
			
			siteline.put(ListEnum.left, rs.getString(1));
			
			siteline.put(ListEnum.right, rs.getString(2));
				
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return siteline;
	}
	
	/**
	 * ���ȼ�Ϊ2
	 * ��ȡ��·վ�������վ����������������վ����������
	 * @param lname
	 * 			��·��
	 * @return linesite
	 * 				��·վ��ö��map����ߡ��ұߣ�
	 */
	public EnumMap<ListEnum,String> getLineSiteSeq(String lname) {
		EnumMap<ListEnum,String> linesite = null;	// ��ȡ����վ����·�����ַ���
		
		
	
		return linesite;
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
		
		
		return sitename;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
