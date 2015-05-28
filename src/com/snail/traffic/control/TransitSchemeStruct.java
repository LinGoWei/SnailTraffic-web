package com.snail.traffic.control;

import java.util.Vector;

/**
 * 方案结构体
 * @author weiliu
 *
 */
public class TransitSchemeStruct {
	public Vector<TransitSToEStruct> transitLine = new Vector<TransitSToEStruct>();// 换乘线路向量
	public int time = 0;	// 方案所需时间
	public int distance = 0;	// 方案距离
}
