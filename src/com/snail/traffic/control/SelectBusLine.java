package com.snail.traffic.control;

/*
 * ��·��ѯ
 * 1.��ǰ�˻�ȡ��·����
 * 2.������·��,�����ݿ��л�ȡ��·�ϵ�վ��(ע��ȥ�кͻ���)��ɵ�����
 * 3.���ز���2������
 */
public class SelectBusLine {

	/**
	 * ��ȡ������·�ϵ�վ������
	 * @param lineName
	 * @return
	 */
	public String[] getLeftSite(String lineName) {
		String[] stopsLeft = null;
		
		/*������·�������ݿ��л�ȡ��·��վ�������stopsLeft*/
		
		//��������
		//String[] stopsLeft = {"�й�","ÿ��","��˼������"};
		
		//�ж��Ƿ���ڸ�����·
		if(stopsLeft == null) {
			System.out.println("���������·������");
		}
		
		return stopsLeft;
		
	}
	
	//��ȡ��·�ϵ�վ����ɵ�����(����)
	public String[] getStopsRight(String lineName) {
		String[] stopsRight = null;
		
		/*������·�������ݿ��л�ȡ��·��վ�������stopsRight*/
		
		//�ж��Ƿ���ڸ�����·
		/*�˴���Ҫ��ǰ�˽��,���������Ϣ*/
		if(stopsRight == null) {
			System.out.println("���������·������");
		}
		
		return stopsRight;
	
	}
	
	//����
	public static void main(String[] args) {
		SelectBusLine ls = new SelectBusLine();
		String[] temp = ls.getLeftSite("����");
		for(int i = 0 ; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
		
	}
	
}
