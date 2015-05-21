 package com.snail.traffic.control;

import java.sql.Connection;
import java.util.EnumMap;

import com.snail.traffic.persistence.ListEnum;

abstract class SelectBase {
	Connection con = null;	// 数据库连接
	
	public SelectBase(Connection con){
		this.con = con;
	}
	
	/**
	 * 查询站点信息函数
	 * 
	 * @param input
	 * 			输入字符串
	 * @return
	 */
	public abstract EnumMap<ListEnum, String[]> query(String input);
}
