package com.snail.traffic.control;

import java.util.Vector;

public interface GetStartToScheme {
	
	// 从向量中获取到达sitename的方案
	public Vector<TransitSToEStruct> getVectorTo(String siteName);
}
