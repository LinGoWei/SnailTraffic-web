package com.snail.traffic.control;

import java.util.Vector;

/**
 * �����ṹ��
 * @author weiliu
 *
 */
public class TransitSchemeStruct {
	public Vector<TransitSToEStruct> transitLine = new Vector<TransitSToEStruct>();// ������·����
	public int time = 0;	// ��������ʱ��
	public int distance = 0;	// ��������
}
