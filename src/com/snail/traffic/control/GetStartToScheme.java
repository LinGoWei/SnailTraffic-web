package com.snail.traffic.control;

import java.util.Vector;

public interface GetStartToScheme {
	
	// �������л�ȡ����sitename�ķ���
	public Vector<TransitSToEStruct> getVectorTo(String siteName);
}
