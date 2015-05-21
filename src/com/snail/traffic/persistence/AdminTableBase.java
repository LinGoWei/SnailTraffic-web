package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class AdminTableBase {

	protected Connection con = null;	// 数据库连接
	
	protected PreparedStatement preinsert = null;	// 插入数据预编译
	
	protected PreparedStatement preupdate = null;	// 更新数据预编译
	
	protected PreparedStatement predelete = null;	// 删除数据预编译	
	
	/**
	 * 初始化预编译语句
	 */
	protected abstract  void initPreparedStatement();
}
