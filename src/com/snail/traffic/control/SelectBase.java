 package com.snail.traffic.control;

import java.sql.Connection;
import java.util.EnumMap;

import com.snail.traffic.persistence.ListEnum;

abstract class SelectBase {
	Connection con = null;	// ���ݿ�����
	
	public SelectBase(Connection con){
		this.con = con;
	}
	
	/**
	 * ��ѯվ����Ϣ����
	 * 
	 * @param input
	 * 			�����ַ���
	 * @return
	 */
	public abstract EnumMap<ListEnum, String[]> query(String input);
}
