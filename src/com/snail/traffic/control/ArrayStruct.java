package com.snail.traffic.control;

public class ArrayStruct {

	private String [] leftStrs 	= null;	// 左行数组
	public String [] rightStrs	= null;	// 右行数组
	public String interval 		= null;	// 线路区间
	public String lineRange		= null; //线路区间
	public String firstOpen		= null; //首站开班
	public String lastOpen		= null; //末站开班
	public String firstClose	= null; //首站收班
	public String lastClose 	= null;	//末站收班
	public String price 		= null;	//票价
	public String cardPrice		= null; //刷卡票价
	public String company		= null; //所属公司
	public String remark		= null;	//备注
	
	/**
	 * 保存数组信息
	 * @param left
	 * 			是否为左边数组
	 * @param str
	 * 			字符串数组
	 */
	public void put(Boolean left, String[] str) {
		if(left)
			leftStrs = str;
		else
			rightStrs = str;
	}
	
	/**
	 * 获取数组信息
	 * @param left
	 * 			是否为左边数组
	 * @return 字符串数组
	 */
	public String[] get(Boolean left) {
		if(left)
			return leftStrs;
		else
			return rightStrs;
	}
}
