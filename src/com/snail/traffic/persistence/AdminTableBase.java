package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class AdminTableBase {

	protected Connection con = null;	// ���ݿ�����
	protected PreparedStatement pre_insert = null;	// ��������Ԥ����
	protected PreparedStatement pre_update = null;	// ��������Ԥ����	
	protected PreparedStatement pre_delete = null;	// ɾ������Ԥ����	
	
	/**
	 * ��ʼ��Ԥ�������
	 */
	protected abstract  void initPreparedStatement();
}
