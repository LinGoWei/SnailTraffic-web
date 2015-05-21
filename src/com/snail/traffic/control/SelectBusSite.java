package com.snail.traffic.control;

import java.sql.Connection;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import com.snail.traffic.persistence.ListEnum;
/**
 * 站点查询功能
 * 2.根据站点名,从数据库中获取该站点所经过的所有线路组成的线路数组(注意去行和回行)
 * 3.返回一个按照站点序号从小到大排列的线路数组数组
 */
class SelectBusSite extends SelectBase {
	
	/**
	 * 构造函数
	 * @param con
	 * 			数据库连接
	 */
	public SelectBusSite(Connection con) {
		super(con);
	}

	/**
	 * 查询站点信息函数
	 * @param input
	 * 			查询关键字
	 * @return siteinfo
	 * 				站点信息
	 */
	public EnumMap<ListEnum, String[]> query(String input) {
		
		EnumMap<ListEnum, String[]> siteinfo = null;	// 
		
		siteinfo.put(ListEnum.left, getLeftLines(input));	// 左边
		siteinfo.put(ListEnum.right, getLeftLines(input));
		
		return siteinfo;
	}
	
	
	/**
	 * 返回一个按照站点序号从小到大排列的线路数组数组(左行)
	 * @param sitename
	 * 				站点名
	 * @return lineSort(leftline)
	 * 				排序好的字符串数组
	 */
	private String[] getLeftLines(String sitename) {
		
		String[] leftlines = null;
		
		// 数据库处理:
		// 输入：String sitename
		// 输出：站点的左行线路集合数组
		
		
		// 判断有无查询的站点信息
		if(leftlines == null)
			System.out.println("无左线");
		
		return lineSort(leftlines);
	}
	
	/**
	 *  返回一个按照站点序号从小到大排列的线路数组数组(右行)
	 * @param sitename
	 * 				站点名
	 * @return 
	 */
	public String[] getRightLines(String sitename) {
		String[] rightlines = null;
		
		// 数据库处理:
		// 输入：String sitename
		// 输出：站点的右行线路集合数组
		
		
		// 判断有无查询的站点信息
		if(rightlines == null)
			System.out.println("无右线");
		
		return lineSort(rightlines);	
	}
	
	/**
	 * 字符串数组排序函数，
	 * 根据线路名称从小到大排序
	 * @param line
	 * 			线路数组
	 * @return line
	 */
	private String[] lineSort(String[] line) {
		//去除数组中的中文,获取路前面的数字组成的数组
		int[] temp = new int[line.length];
		
		for(int i = 0; i < line.length; i++) {
			line[i] = line[i].replace("路", "");
			
			temp[i] = Integer.parseInt(line[i]);
		}
		
		Arrays.sort(temp);
		
		for(int i = 0; i <temp.length; i++)
			line[i] = temp[i] + "路";
		
		return line;
	}
	
	/**
	 * 模糊查询中根据部分信息,匹配符合的全称(无需判断是否有匹配项)
	 * @param partname
	 * 				站点名
	 * @return fullname
	 * 				站点全称
	 */
	public String[] getFullName(String partname) {
		String[] fullname = null;
		/*数据库操作:根据partName返回匹配的fullName数组*/
		
		return fullname;	
	}
	

}
