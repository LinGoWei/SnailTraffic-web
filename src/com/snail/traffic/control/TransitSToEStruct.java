package com.snail.traffic.control;

import java.util.Vector;

/**
 * ��ͨ���ϳ�վ�㵽�³�վ��
 * @author weiliu
 *
 */
public class TransitSToEStruct {
	public String startSite = null;	// �ϳ�վ����	
	public String endSite	= null;	// �³�վ����
	public Vector<String> route = new Vector<String>();	// ·��
	public int isLeft		= 0;	// �Ƿ�����
	public String lineName	= null;	// ��·��
	public int time 		= 0;
	public int distance 	= 0;
}
