package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class AdminTableBase {

	protected Connection con = null;	// 数据库连接
	protected PreparedStatement pre_insert = null;	// 插入数据预编译
	protected PreparedStatement pre_update = null;	// 更新数据预编译	
	protected PreparedStatement pre_delete = null;	// 删除数据预编译	
	
	/**
	 * 初始化预编译语句
	 */
	protected abstract  void initPreparedStatement();
}
