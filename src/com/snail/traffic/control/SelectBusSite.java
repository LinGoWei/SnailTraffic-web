package com.snail.traffic.control;

import java.sql.Connection;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import com.snail.traffic.persistence.ListEnum;
/**
 * վ���ѯ����
 * 2.����վ����,�����ݿ��л�ȡ��վ����������������·��ɵ���·����(ע��ȥ�кͻ���)
 * 3.����һ������վ����Ŵ�С�������е���·��������
 */
class SelectBusSite extends SelectBase {
	
	/**
	 * ���캯��
	 * @param con
	 * 			���ݿ�����
	 */
	public SelectBusSite(Connection con) {
		super(con);
	}

	/**
	 * ��ѯվ����Ϣ����
	 * @param input
	 * 			��ѯ�ؼ���
	 * @return siteinfo
	 * 				վ����Ϣ
	 */
	public EnumMap<ListEnum, String[]> query(String input) {
		
		EnumMap<ListEnum, String[]> siteinfo = null;	// 
		
		siteinfo.put(ListEnum.left, getLeftLines(input));	// ���
		siteinfo.put(ListEnum.right, getLeftLines(input));
		
		return siteinfo;
	}
	
	
	/**
	 * ����һ������վ����Ŵ�С�������е���·��������(����)
	 * @param sitename
	 * 				վ����
	 * @return lineSort(leftline)
	 * 				����õ��ַ�������
	 */
	private String[] getLeftLines(String sitename) {
		
		String[] leftlines = null;
		
		// ���ݿ⴦��:
		// ���룺String sitename
		// �����վ���������·��������
		
		
		// �ж����޲�ѯ��վ����Ϣ
		if(leftlines == null)
			System.out.println("������");
		
		return lineSort(leftlines);
	}
	
	/**
	 *  ����һ������վ����Ŵ�С�������е���·��������(����)
	 * @param sitename
	 * 				վ����
	 * @return 
	 */
	public String[] getRightLines(String sitename) {
		String[] rightlines = null;
		
		// ���ݿ⴦��:
		// ���룺String sitename
		// �����վ���������·��������
		
		
		// �ж����޲�ѯ��վ����Ϣ
		if(rightlines == null)
			System.out.println("������");
		
		return lineSort(rightlines);	
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
		int[] temp = new int[line.length];
		
		for(int i = 0; i < line.length; i++) {
			line[i] = line[i].replace("·", "");
			
			temp[i] = Integer.parseInt(line[i]);
		}
		
		Arrays.sort(temp);
		
		for(int i = 0; i <temp.length; i++)
			line[i] = temp[i] + "·";
		
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
