package com.snail.traffic.control;

public class ArrayStruct {

	private String [] leftStrs 	= null;	// ��������
	public String [] rightStrs	= null;	// ��������
	public String interval 		= null;	// ��·����
	public String lineRange		= null; //��·����
	public String firstOpen		= null; //��վ����
	public String lastOpen		= null; //ĩվ����
	public String firstClose	= null; //��վ�հ�
	public String lastClose 	= null;	//ĩվ�հ�
	public String price 		= null;	//Ʊ��
	public String cardPrice		= null; //ˢ��Ʊ��
	public String company		= null; //������˾
	public String remark		= null;	//��ע
	
	/**
	 * ����������Ϣ
	 * @param left
	 * 			�Ƿ�Ϊ�������
	 * @param str
	 * 			�ַ�������
	 */
	public void put(Boolean left, String[] str) {
		if(left)
			leftStrs = str;
		else
			rightStrs = str;
	}
	
	/**
	 * ��ȡ������Ϣ
	 * @param left
	 * 			�Ƿ�Ϊ�������
	 * @return �ַ�������
	 */
	public String[] get(Boolean left) {
		if(left)
			return leftStrs;
		else
			return rightStrs;
	}
}
