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
	
	// ���캯��
	public SelectTransit(Connection con) {
		this.selOper = new SelectOperated(con);
	}
	
	/**
	 *  �󽻼�
	 *  ������һ�ŵ�������
	 *  �ж�������е�Ԫ���Ƿ���������
	 *  ��������������Set������
	 * @param arr1
	 * @param arr2
	 * @return 
	 */
    public String[] intersect(String[] arr1, String[] arr2) {
        List<String> list = new LinkedList<String>();	// ����
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
	 * ���˲�ѯ
	 * ���ȼ���Ƿ�ֱ��
	 * ����Ƿ����һ�λ���
	 * @param start
	 * 			��ʼ�ϳ�վ��
	 * @param end
	 * 			�����³�վ��
	 * @return
	 */
	public Vector<TransitSchemeStruct> query(String start, String end) {
		if (start == null || end == null)
			return null;
		
		// ���봦��
		start = start.trim();
		end = end.trim();
		
		// ����ʼվ������ֹվ���ظ�ʱ
		if (start.equals(end)) 
			return null;
		
		Vector<TransitSchemeStruct> schemes = new Vector<TransitSchemeStruct>();// ��������
		DirectVectorBase directV = new DirectVector();
		DirectVectorBase be_directV = new Be_DirectVector();
		
		// ���ù�ϵվ����
		directV.relateSite = start;

		// �����ʼվ������п�ֱ��վ��
		directV.relateVector = this.selOper.getDirectAccessSites(start);
		
		// ������������3�������ɷ��ػ��˲�ѯ���
		if (through(schemes, directV, end) >= 3)
			return schemes;
		
		
		
		be_directV.relateSite = end;
		
		be_directV.relateVector = this.selOper.get_Be_DirectAccessSites(end);
		
		
		
		return schemes;
	}
	
	/**
	 * ����Ŀ��վ���ȡֱ�﷽��
	 * @param Scheme
	 * 			��������
	 * @param vector
	 * 			��ʼվ������
	 * @param end
	 * 			Ŀ��վ��
	 */
	private int through(Vector<TransitSchemeStruct> allScheme, DirectVectorBase direct, String end) {
		Vector<TransitSToEStruct> transitVecter = direct.getVectorTo(end); // ���ֱ�﷽��
		TransitSchemeStruct scheme = null;	// ���˷���Ԫ��
		
		int size = transitVecter.size();
		// ֱ��˳���������һ������
		for (int i = 0; i < size; i++) {
			scheme = new TransitSchemeStruct();
			scheme.transitLine.add(transitVecter.get(i));
			scheme.time = transitVecter.get(i).time;
			scheme.distance = transitVecter.get(i).distance;
			allScheme.add(scheme); // ��Ԫ�ؼ��뵽������
		}
		System.out.print(allScheme.size());
		return allScheme.size();
	}
	

	public static void main(String[] args) {
		OracleBase oracle = new OracleBase();
		Connection con = oracle.getConnection();
		SelectTransit a = new SelectTransit(con);
		a.query("������˫��", "�������ºϴ�");
	}
	
    
}
