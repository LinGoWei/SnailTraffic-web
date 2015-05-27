package com.snail.traffic.control;

import java.sql.Connection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.snail.traffic.persistence.DirectAccessStruct;
import com.snail.traffic.persistence.OracleBase;
import com.snail.traffic.persistence.SelectOperated;

public class SelectTransit {
	private SelectOperated selOper = null;
	
	// 构造函数
	public SelectTransit(Connection con) {
		this.selOper = new SelectOperated(con);
	}
	
	/**
	 *  求交集
	 *  把数组一放到链表中
	 *  判断数组二中的元素是否在链表中
	 *  若包含，保存至Set集合中
	 * @param arr1
	 * @param arr2
	 * @return 
	 */
    public String[] intersect(String[] arr1, String[] arr2) {
        List<String> list = new LinkedList<String>();	// 链表
        Set<String> common = new HashSet<String>(); 
        
        for (String str:arr1)
            if (!list.contains(str))
            	list.add(str);

        for (String str:arr2)
            if (list.contains(str))
                common.add(str);

        String[] result = {};
        return common.toArray(result);
    }
    
	/**
	 * 换乘查询
	 * 首先检查是否直达
	 * 检查是否存在一次换乘
	 * @param start
	 * 			起始上车站点
	 * @param end
	 * 			最终下车站点
	 * @return
	 */
	public Vector<TransitSchemeStruct> query(String start, String end) {
		if (start == null || end == null)
			return null;
		
		// 输入处理
		start = start.trim();
		end = end.trim();
		
		// 当起始站点与终止站点重复时
		if (start.equals(end)) 
			return null;
		
		Vector<TransitSchemeStruct> schemes = new Vector<TransitSchemeStruct>();// 方案向量
		DirectVectorBase directV = new DirectVector();
		DirectVectorBase be_directV = new Be_DirectVector();
		
		// 设置关系站点名
		directV.relateSite = start;

		// 获得起始站点的所有可直达站点
		directV.relateVector = this.selOper.getDirectAccessSites(start);
		
		// 若方案数大于3个，即可返回换乘查询结果
		if (through(schemes, directV, end) >= 3)
			return schemes;
		
		
		
		be_directV.relateSite = end;
		
		be_directV.relateVector = this.selOper.get_Be_DirectAccessSites(end);
		
		
		
		return schemes;
	}
	
	/**
	 * 根据目标站点获取直达方案
	 * @param Scheme
	 * 			方案向量
	 * @param vector
	 * 			起始站点向量
	 * @param end
	 * 			目标站点
	 */
	private int through(Vector<TransitSchemeStruct> allScheme, DirectVectorBase direct, String end) {
		Vector<TransitSToEStruct> transitVecter = direct.getVectorTo(end); // 获得直达方案
		TransitSchemeStruct scheme = null;	// 换乘方案元素
		
		int size = transitVecter.size();
		// 直达乘车方案就是一个方案
		for (int i = 0; i < size; i++) {
			scheme = new TransitSchemeStruct();
			scheme.transitLine.add(transitVecter.get(i));
			scheme.time = transitVecter.get(i).time;
			scheme.distance = transitVecter.get(i).distance;
			allScheme.add(scheme); // 把元素加入到向量中
		}
		System.out.print(allScheme.size());
		return allScheme.size();
	}
	

	public static void main(String[] args) {
		OracleBase oracle = new OracleBase();
		Connection con = oracle.getConnection();
		SelectTransit a = new SelectTransit(con);
		a.query("建设大道双墩", "建设大道新合村");
	}
	
    
}
