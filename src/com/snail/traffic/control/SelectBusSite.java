package com.snail.traffic.control;

import java.sql.Connection;
import java.util.Arrays;

import com.snail.traffic.persistence.SelectOperated;
import com.snail.traffic.persistence.TwoLongStruct;
/**
 * 站点查询功能
 * 2.根据站点名,从数据库中获取该站点所经过的所有线路组成的线路数组(注意去行和回行)
 * 3.返回一个按照站点序号从小到大排列的线路数组数组
 */
class SelectBusSite extends SelectBase {
	
	SelectOperated seloper = null;
	/**
	 * 构造函数
	 * @param con
	 * 			数据库连接
	 */
	public SelectBusSite(Connection con) {
		seloper = new SelectOperated(con);
	}

	/**
	 * 查询站点信息函数
	 * @param input
	 * 			查询关键字
	 * @return siteinfo
	 * 				站点信息
	 */
	public ArrayStruct query(String input) {
		
		TwoLongStruct lineSeq = seloper.getSiteLineSeq(input);	// 获取两条长串字符
		
		ArrayStruct siteinfo = new ArrayStruct();	// 声明定义站点信息数组
		
		siteinfo.put(true, getLines(lineSeq.get(true)));	// 把左边的线路名数组放到左边
		siteinfo.put(false, getLines(lineSeq.get(false)));	
		
		return siteinfo;
	}
	
	
	/**
	 * 返回一个按照站点序号从小到大排列的线路数组数组
	 * @param sitename
	 * 				站点名
	 * @return lineSort(lines)
	 * 				排序好的字符串数组
	 */
	private String[] getLines(String lidseq) {
		if(lidseq == null)
			return null;
		String[] lines = lidseq.split(",");	// 经过站点的左线路
		
		for(int i = 0; i < lines.length; i++)
			lines[i] = seloper.getLineName(Integer.parseInt(lines[i])); // 把线路名替换线路代码字符串

		return lineSort(lines);
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
//		int[] temp = new int[line.length];
//		
//		for(int i = 0; i < line.length; i++) {
//			line[i] = line[i].replace("路", "");
//			
//			temp[i] = Integer.parseInt(line[i]);
//		}
//		
//		Arrays.sort(temp);
//		
//		for(int i = 0; i <temp.length; i++)
//			line[i] = temp[i] + "路";
		
		Arrays.sort(line);
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
