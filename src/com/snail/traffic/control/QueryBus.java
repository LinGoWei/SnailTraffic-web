package com.snail.traffic.control;

import java.sql.Connection;
import java.util.EnumMap;
import java.util.Map;

import com.snail.traffic.persistence.ListEnum;
import com.snail.traffic.persistence.OracleBase;

/**
 * ������ѯ�࣬
 * ����վ���ѯ����·��ѯ�����˲�ѯ��һ���ؼ�
 * @author weiliu
 *
 */
public class QueryBus {
	
	private OracleBase oracle = new OracleBase();	// ���ݿ����
	
	private Connection con = oracle.getConnection();	// ��ȡ���ݿ�����
	
	/**
	 * վ���ѯAPI
	 * @param sitename
	 * 				վ����
	 * @return
	 */
	public EnumMap<ListEnum, String> queryBusSite(String sitename){
		EnumMap<ListEnum, String> siteinfo = null;
		
		return siteinfo;
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
