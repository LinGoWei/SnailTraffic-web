package com.snail.traffic.control;

import java.sql.Connection;
import java.util.EnumMap;
import java.util.Map;

import com.snail.traffic.persistence.ListEnum;
import com.snail.traffic.persistence.OracleBase;

/**
 * 公交查询类，
 * 包括站点查询、线路查询，换乘查询与一键回家
 * @author weiliu
 *
 */
public class QueryBus {
	
	private OracleBase oracle = new OracleBase();	// 数据库对象
	
	private Connection con = oracle.getConnection();	// 获取数据库连接
	
	/**
	 * 站点查询API
	 * @param sitename
	 * 				站点名
	 * @return
	 */
	public EnumMap<ListEnum, String> queryBusSite(String sitename){
		EnumMap<ListEnum, String> siteinfo = null;
		
		return siteinfo;
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
