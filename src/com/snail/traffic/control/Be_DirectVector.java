package com.snail.traffic.control;

import java.util.Set;
import java.util.Vector;

import com.snail.traffic.persistence.BeDirectAccessStruct;

public class Be_DirectVector extends DirectVectorBase{

	/**
	 * ��ֱ���վ������
	 */
	public Be_DirectVector() {
		relateVector = new Vector<BeDirectAccessStruct>();
	}

	/**
	 *  �ӱ�ֱ�������л�ȡ����sitename�ķ���
	 */
	public Vector<TransitSToEStruct> getVectorTo(String name) {
		
		return null;
	}

	/**
	 * �ѱ�ֱ������ת���ɼ���
	 */
	public Set<String> getSetFromVector() {
		
		return null;
	}

}
