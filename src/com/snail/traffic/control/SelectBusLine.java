package com.snail.traffic.control;

import java.sql.Connection;

import com.snail.traffic.persistence.SelectOperated;
import com.snail.traffic.persistence.TwoLongStruct;

/*
 * ��·��ѯ
 * 1.��ǰ�˻�ȡ��·����
 * 2.������·��,�����ݿ��л�ȡ��·�ϵ�վ��(ע��ȥ�кͻ���)��ɵ�����
 * 3.���ز���2������
 */
public class SelectBusLine extends SelectBase {
	SelectOperated seloper = null;	// ���ݿ��ѯ����
	
	/**
	 * ���캯��
	 * @param con
	 * 			���ݿ�����
	 */
	public SelectBusLine(Connection con) {
		this.seloper = new SelectOperated(con);
	}
	
	/**
	 * ��ѯ��·��Ϣ����
	 * @param input
	 * 			��ѯ�ؼ���
	 * @return lineinfo
	 * 				վ����Ϣ
	 */
	public ArrayStruct query(String input) {
		ArrayStruct lineinfo = seloper.getLineInfo(input);		// ��ȡ��·������Ϣ
		TwoLongStruct sidSeq = seloper.getLineSiteSeq(input);	// ��ȡ���������ַ�
		
		lineinfo.put(true, getSites(sidSeq.get(true)));	// ����ߵ���·������ŵ����
		lineinfo.put(false, getSites(sidSeq.get(false)));	
		
		return lineinfo;
	}
	
	private String[] getSites(String sidseq) {
		if(sidseq == null)	// վ������Ϊ��ʱ������
			return null;
		
		String[] sites = sidseq.split(",");	// ����վ�������·
		
		for(int i = 0; i < sites.length; i++)
			sites[i] = seloper.getLineName(Integer.parseInt(sites[i])); // ����·���滻��·�����ַ���
		
		return sites;
	}
}
