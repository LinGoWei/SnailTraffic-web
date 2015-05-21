package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class AdminTableBase {

	protected Connection con = null;	// ���ݿ�����
	
	protected PreparedStatement preinsert = null;	// ��������Ԥ����
	
	protected PreparedStatement preupdate = null;	// ��������Ԥ����
	
	protected PreparedStatement predelete = null;	// ɾ������Ԥ����	
	
	/**
	 * ��ʼ��Ԥ�������
	 */
	protected abstract  void initPreparedStatement();
}
