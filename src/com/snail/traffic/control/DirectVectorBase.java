package com.snail.traffic.control;

import java.util.Set;
import java.util.Vector;


public abstract class DirectVectorBase {
	
	public String relateSite = null;	// ��ϵվ��
	
	public Vector<?> relateVector;	// ����
	
	/**
	 *  �������л�ȡ����sitename�ķ���
	 */
	public abstract Vector<TransitSToEStruct> getVectorTo(String name); // �������л�ȡ����sitename�ķ���
	
	/**
	 * ������ת���ɼ���
	 */
	public abstract Set<String> getSetFromVector();	// ������ת���ɼ���
	
}
