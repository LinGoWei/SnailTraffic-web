package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumMap;

/**
 * 查询数据库类
 * 
 * 此类中只做最基本的数据库表的查询或视图查询
 * 
 * 只需要定义好查询的API,至于查询后干什么用，查询后得到什么格式
 * 
 * 我都不管，啦啦啦
 * 
 * @author weiliu
 *
 */
public class SelectOperated {
	private Connection con = null;	// 声明数据库连接
	
	private PreparedStatement pre_viewSiteLine = null;	// 查询站点线路视图预编译
	private PreparedStatement pre_viewLineSite = null;	// 查询线路站点视图预编译
	
	private PreparedStatement pre_tableLineName = null;	// 查询线路名预编译
	private PreparedStatement pre_tableSiteName = null;	// 查询站点名预编译
	
	private String leftSiteLine = null;		// 站点左线路数组
	private String rightSiteLine = null;	// 站点右线路数组
	private String leftSites = null;		// 线路左行站点数组
	private String rightSites = null;		// 线路右行站点数组
	
	
	public SelectOperated(Connection con){
		this.con = con;
		initPreparedStatement();	// 初始化预编译
	}
	
	/**
	 * 初始化预编译语句
	 */
	private void initPreparedStatement(){
		try {
			String viewSiteLine = "SELECT llidseq, rlidseq FROM　View_SiteLine　 WHERE sname = ?";	
			String viewLineSite = "SELECT lsidseq, rsidseq FROM　View_LineSite　 WHERE lname = ?";
			
			String tableLineName = "SELECT lname FROM　LineInfo　 WHERE lid = ?";
			String tableSiteName = "SELECT sname FROM　SiteInfo　 WHERE sid = ?";

			pre_viewSiteLine = con.prepareStatement(viewSiteLine);
			pre_viewLineSite = con.prepareStatement(viewLineSite);
			
			pre_tableLineName = con.prepareStatement(tableLineName);
			pre_tableSiteName = con.prepareStatement(tableSiteName);

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * 获取左行与右行站点线路序列字符串API
	 * @param sitename
	 * 				站点名
	 * @return siteline
	 * 				站点线路枚举map(包括左边，右边)
	 */
	public EnumMap<ListEnum,String> getSiteLineSeq(String sitename) {
		
		EnumMap<ListEnum,String> siteline = null;	// 两边站点线路序列字符串
		
		try {
			pre_viewSiteLine.setString(1, sitename);
			
			ResultSet rs = pre_viewSiteLine.executeQuery();
			
			siteline.put(ListEnum.left, rs.getString(1));
			
			siteline.put(ListEnum.right, rs.getString(2));
				
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return siteline;
	}
	
	/**
	 * 优先级为2
	 * 获取线路站点表左行站点序列数组与右行站点序列数组
	 * @param lname
	 * 			线路名
	 * @return linesite
	 * 				线路站点枚举map（左边、右边）
	 */
	public EnumMap<ListEnum,String> getLineSiteSeq(String lname) {
		EnumMap<ListEnum,String> linesite = null;	// 获取两边站点线路序列字符串
		
		
	
		return linesite;
	}
	
	/**
	 * 通过线路id获得线路名
	 * 
	 * @param lid
	 * 			输入线路id
	 * @return linename
	 */
	public String getLineName(int lid) {
		String linename = null;	// 线路名
		
		try {
			pre_tableLineName.setInt(1, lid);	// 设置参数
			
			ResultSet rs = pre_tableLineName.executeQuery();
			
			linename = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linename;	
	}
	
	/**
	 * 优先级为2
	 * 通过站点id获得站点名
	 * @param sid
	 * 			站点id
	 * @return sitename
	 * 				站点名
	 */
	public String getSiteName(int sid) {
		String sitename = null;	// 站点名
		
		
		return sitename;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
