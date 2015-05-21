package com.snail.traffic.control;

/*
 * 线路查询
 * 1.从前端获取线路名称
 * 2.根据线路名,从数据库中获取线路上的站点(注意去行和回行)组成的数组
 * 3.返回步骤2的数组
 */
public class SelectBusLine {

	/**
	 * 获取左行线路上的站点数组
	 * @param lineName
	 * @return
	 */
	public String[] getLeftSite(String lineName) {
		String[] stopsLeft = null;
		
		/*根据线路名从数据库中获取线路上站点的数组stopsLeft*/
		
		//测试数据
		//String[] stopsLeft = {"中国","每个","的思考过后"};
		
		//判断是否存在该条线路
		if(stopsLeft == null) {
			System.out.println("您输入的线路不存在");
		}
		
		return stopsLeft;
		
	}
	
	//获取线路上的站点组成的数组(右行)
	public String[] getStopsRight(String lineName) {
		String[] stopsRight = null;
		
		/*根据线路名从数据库中获取线路上站点的数组stopsRight*/
		
		//判断是否存在该条线路
		/*此处需要和前端结合,输出错误信息*/
		if(stopsRight == null) {
			System.out.println("您输入的线路不存在");
		}
		
		return stopsRight;
	
	}
	
	//测试
	public static void main(String[] args) {
		SelectBusLine ls = new SelectBusLine();
		String[] temp = ls.getLeftSite("测试");
		for(int i = 0 ; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
		
	}
	
}
