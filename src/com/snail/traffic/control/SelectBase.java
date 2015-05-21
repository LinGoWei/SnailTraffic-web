 package com.snail.traffic.control;

abstract class SelectBase {
	
	/**
	 * 查询站点信息函数
	 * 
	 * @param input
	 * 			输入字符串
	 * @return
	 */
	public abstract ArrayStruct query(String input);
}
