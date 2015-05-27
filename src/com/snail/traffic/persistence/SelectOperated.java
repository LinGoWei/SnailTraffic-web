package com.snail.traffic.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

import com.snail.traffic.control.TransitSToEStruct;

/**
 * ��ѯ���ݿ���
 * 
 * ������ֻ������������ݿ���ͼ��ѯ
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
	private CallableStatement pre_DirectAccess = null;	// ֱ��վ���ѯԤ����
	private CallableStatement pre_BeDirectAccess = null;	// ֱ��վ���ѯԤ����
	
	private ResultSet rs = null;
	
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

			pre_viewSiteLine = con.prepareStatement(viewSiteLine);
			pre_viewLineSite = con.prepareStatement(viewLineSite);	
			pre_DirectAccess = con.prepareCall("BEGIN DIRECTACCESS(?, ?); END;");
			pre_BeDirectAccess = con.prepareCall("BEGIN BEDIRECTACCESS(?, ?); END;");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * ������ͼ����ȡ����������վ����·�����ַ���API
	 * @param sitename
	 * 				վ����
	 * @return siteline
	 * 				վ����·(������ߣ��ұ�)
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
	 * ��ȡ��·վ�������վ������������վ������
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
	 * ͨ����ʼվ��������·������¸�վ�����뵽���¸�վ���ʱ�������
	 * @param start
	 * 			��ʼվ��
	 * @param line
	 * 			��·��
	 * @return
	 * 
	 */
	public TransitSToEStruct getNextSite(String start, String line) {
		TransitSToEStruct ste = new TransitSToEStruct();
		CallableStatement proc = null;
	      try {
			proc = con.prepareCall("{ call G7.SELECTNEXTSITE(?,?,?,?,?,?) }");
		    proc.setString(1, start);
		    proc.setString(2, line);
		    
		    proc.registerOutParameter(3, Types.INTEGER);
		    proc.registerOutParameter(4, Types.VARCHAR);
		    proc.registerOutParameter(5, Types.INTEGER);
		    proc.registerOutParameter(6, Types.INTEGER);
		    proc.execute();
		    
		    ste.isLeft = proc.getInt(3);
		    ste.endSite = proc.getString(4);	// ��һ��վ��
		    ste.time = proc.getInt(5);
		    ste.distance = proc.getInt(6);
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ste.startSite = start;
		ste.lineName = line;
		return ste;
	}
	
	/**
	 * ��ȡ��ʼվ��Ŀ�ֱ��վ������
	 * @param startSite
	 * 				��ʼվ��
	 * @return directSites
	 * 				��ֱ��վ�����Ϣ����
	 */
	public Vector<DirectAccessStruct> getDirectAccessSites(String startSite) {
		Vector<DirectAccessStruct> directSites = new Vector<DirectAccessStruct>();// ��ֱ��վ������
		DirectAccessStruct newElement = new DirectAccessStruct();
		try {
			pre_DirectAccess.setString(1, startSite);
			pre_DirectAccess.registerOutParameter(2, OracleTypes.CURSOR);
			pre_DirectAccess.execute();
			rs = ((OracleCallableStatement)pre_DirectAccess).getCursor(2);
			
			while (rs.next()) {
				newElement.sname = rs.getString("SNAME");
				newElement.lname = rs.getString("LNAME");
				newElement.runLeft = rs.getInt("RUNLEFT");
				newElement.runTime = rs.getInt("RUNTIME");
				newElement.distance = rs.getInt("DISTANCE");
				directSites.add(newElement);
				System.out.println(newElement.sname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return directSites;
	}
	
	public Vector<BeDirectAccessStruct> get_Be_DirectAccessSites(String endSite) {
		Vector<BeDirectAccessStruct> directSites = new Vector<BeDirectAccessStruct>();// ��ֱ��վ������
		BeDirectAccessStruct newElement = new BeDirectAccessStruct();
		
		try {
			pre_DirectAccess.setString(1, endSite);
			pre_DirectAccess.registerOutParameter(2, OracleTypes.CURSOR);
			pre_DirectAccess.execute();
			rs = ((OracleCallableStatement)pre_DirectAccess).getCursor(2);
			
			while (rs.next()) {
				newElement.sname = rs.getString("SNAME");
				newElement.lname = rs.getString("LNAME");
				newElement.runLeft = rs.getInt("RUNLEFT");
				directSites.add(newElement);
				System.out.println(newElement.sname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return directSites;
	}
	
	
	public static void main(String[] args) {
		OracleBase oracle = new OracleBase();
		Connection con = oracle.getConnection();
		SelectOperated aa = new SelectOperated(con);
		// aa.getDirectAccessSites("������˫��");
		aa.get_Be_DirectAccessSites("������˫��");
	}
	
}
