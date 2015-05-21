package com.snail.traffic.control;

import java.sql.Connection;
import java.util.EnumMap;

import com.snail.traffic.persistence.ListEnum;
import com.snail.traffic.persistence.OracleBase;

/**
 * ������ѯ�࣬
 * ����վ���ѯ����·��ѯ�����˲�ѯ��һ���ؼ�
 * @author weiliu
 *
 */
public class QueryBus {
	
	private static OracleBase oracle = new OracleBase();	// ���ݿ����
	
	private static Connection con = oracle.getConnection();	// ��ȡ���ݿ�����
	
	/**
	 * վ���ѯAPI
	 * @param sitename
	 * 				վ����
	 * @return ��ѯ���map
	 * 			���ͣ�EnumMap<ListEnum, String[]>
	 */
	public static ArrayStruct queryBusSite(String sitename){
		SelectBase selectSite = new SelectBusSite(con);		// ��������һ����ѯ����
		
		return selectSite.query(sitename);	// ����һ����ѯ���map
	}
	
	
	public static void main(String[] args) {
		
		// ���ڻ�վ
		ArrayStruct emap = queryBusSite("���ڻ�վ");
		
		String[] earr = emap.get(true);
		
		String[] err = emap.get(false);
		if(earr != null) {
			
			System.out.println(earr.length);
			for(int i = 0; i < earr.length; i++)
				System.out.println(earr[i]);
		}
		else
			System.out.println("���Ϊ��");
		
		if(err != null) {
			System.out.println(err.length);
			for(int i = 0; i < err.length; i++)
				System.out.println(err[i]);
		}
		else
			System.out.println("�ұ�Ϊ��");

	}

}
