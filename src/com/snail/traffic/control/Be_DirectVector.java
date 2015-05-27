package com.snail.traffic.control;

import java.util.Set;
import java.util.Vector;

import com.snail.traffic.persistence.BeDirectAccessStruct;

public class Be_DirectVector extends DirectVectorBase{

	/**
	 * 被直达的站点向量
	 */
	public Be_DirectVector() {
		relateVector = new Vector<BeDirectAccessStruct>();
	}

	/**
	 *  从被直达向量中获取到达sitename的方案
	 */
	public Vector<TransitSToEStruct> getVectorTo(String name) {
		
		return null;
	}

	/**
	 * 把被直达向量转换成集合
	 */
	public Set<String> getSetFromVector() {
		
		return null;
	}

}
