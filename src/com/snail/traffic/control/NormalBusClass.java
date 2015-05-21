package com.snail.traffic.control;

public class NormalBusClass{
	
	public String lineName;       //线路名称
	public String lineRange;     //线路区间
	public String[] goStops;      //去行停靠站点
	public String[] comeStops;    //回行停靠站点
	public String firstOpen;      //首站开班
	public String lastOpen;       //末站开班
	public String firstClose;     //首站收班
	public String lastClose;      //末站收班
	public String price;          //票价
	public String cardPrice;      //刷卡票价
	public String company;        //所属公司
	public String remark;         //备注
	
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