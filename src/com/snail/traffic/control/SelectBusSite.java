package com.snail.traffic.control;

import java.sql.Connection;
import java.util.Arrays;

import com.snail.traffic.persistence.SelectOperated;
import com.snail.traffic.persistence.TwoLongStruct;
/**
 * վ���ѯ����
 * 2.����վ����,�����ݿ��л�ȡ��վ����������������·��ɵ���·����(ע��ȥ�кͻ���)
 * 3.����һ������վ����Ŵ�С�������е���·��������
 */
class SelectBusSite extends SelectBase {
	
	SelectOperated seloper = null;
	/**
	 * ���캯��
	 * @param con
	 * 			���ݿ�����
	 */
	public SelectBusSite(Connection con) {
		seloper = new SelectOperated(con);
	}

	/**
	 * ��ѯվ����Ϣ����
	 * @param input
	 * 			��ѯ�ؼ���
	 * @return siteinfo
	 * 				վ����Ϣ
	 */
	public ArrayStruct query(String input) {
		
		TwoLongStruct lineSeq = seloper.getSiteLineSeq(input);	// ��ȡ���������ַ�
		
		ArrayStruct siteinfo = new ArrayStruct();	// ��������վ����Ϣ����
		
		siteinfo.put(true, getLines(lineSeq.get(true)));	// ����ߵ���·������ŵ����
		siteinfo.put(false, getLines(lineSeq.get(false)));	
		
		return siteinfo;
	}
	
	
	/**
	 * ����һ������վ����Ŵ�С�������е���·��������
	 * @param sitename
	 * 				վ����
	 * @return lineSort(lines)
	 * 				����õ��ַ�������
	 */
	private String[] getLines(String lidseq) {
		if(lidseq == null)
			return null;
		String[] lines = lidseq.split(",");	// ����վ�������·
		
		for(int i = 0; i < lines.length; i++)
			lines[i] = seloper.getLineName(Integer.parseInt(lines[i])); // ����·���滻��·�����ַ���

		return lineSort(lines);
	}
	
	/**
	 * �ַ���������������
	 * ������·���ƴ�С��������
	 * @param line
	 * 			��·����
	 * @return line
	 */
	private String[] lineSort(String[] line) {
		//ȥ�������е�����,��ȡ·ǰ���������ɵ�����
//		int[] temp = new int[line.length];
//		
//		for(int i = 0; i < line.length; i++) {
//			line[i] = line[i].replace("·", "");
//			
//			temp[i] = Integer.parseInt(line[i]);
//		}
//		
//		Arrays.sort(temp);
//		
//		for(int i = 0; i <temp.length; i++)
//			line[i] = temp[i] + "·";
		
		Arrays.sort(line);
		return line;
	}
	
	/**
	 * ģ����ѯ�и��ݲ�����Ϣ,ƥ����ϵ�ȫ��(�����ж��Ƿ���ƥ����)
	 * @param partname
	 * 				վ����
	 * @return fullname
	 * 				վ��ȫ��
	 */
	public String[] getFullName(String partname) {
		String[] fullname = null;
		/*���ݿ����:����partName����ƥ���fullName����*/
		
		return fullname;	
	}
	

}
