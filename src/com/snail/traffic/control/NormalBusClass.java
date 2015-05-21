package com.snail.traffic.control;

public class NormalBusClass{
	
	public String lineName;       //��·����
	public String lineRange;     //��·����
	public String[] goStops;      //ȥ��ͣ��վ��
	public String[] comeStops;    //����ͣ��վ��
	public String firstOpen;      //��վ����
	public String lastOpen;       //ĩվ����
	public String firstClose;     //��վ�հ�
	public String lastClose;      //ĩվ�հ�
	public String price;          //Ʊ��
	public String cardPrice;      //ˢ��Ʊ��
	public String company;        //������˾
	public String remark;         //��ע
	
	void showSheet1() {
		System.out.print(lineName + " " + lineRange + " "); 
		
		showX1();
		
		System.out.println(  firstOpen + " " + lastOpen + " " + firstClose + " " + lastOpen 
				             + firstClose + " " + lastClose + " " + price +" " + cardPrice +" " 
				             + company + " " + remark + " " );
				           
	}
	
	void showX1() {
		for (int i = 0; i < goStops.length;i++)
			System.out.print(goStops[i]+" ");
		
		for(int j = 0; j < comeStops.length; j++)
			System.out.print(comeStops[j] +" ");
	}
}