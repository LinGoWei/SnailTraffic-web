package com.snail.traffic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.snail.traffic.control.ArrayStruct;

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
	
	private PreparedStatement pre_tableLineInfo = null;	// 查询线路信息的预编译	
	
	public SelectOperated(Connection con) {
		this.con = con;
		initPreparedStatement();	// 初始化预编译
	}
	
	/**
	 * 初始化预编译语句
	 */
	private void initPreparedStatement() {
		try {
			String viewSiteLine = "SELECT llidseq, rlidseq FROM　View_SiteLine　 WHERE sname = ?";	
			String viewLineSite = "SELECT lsidseq, rsidseq FROM　View_LineSite　 WHERE lname = ?";
			
			String tableLineName = "SELECT lname FROM　LineInfo　 WHERE lid = ?";
			String tableSiteName = "SELECT sname FROM　SiteInfo　 WHERE sid = ?";

			String tableLineInfo = "SELECT lname, LINTERVAL"
									+ ", LFIRSTOPEN, LLASTOPEN, LFIRSTCLOSE, LLASTCLOSE"
									+ ", LPRICE, LCARDPRICE, LCOMPANY"
									+ " FROM　LineInfo"
									+ " WHERE lname = ?";
			
			pre_viewSiteLine = con.prepareStatement(viewSiteLine);
			pre_viewLineSite = con.prepareStatement(viewLineSite);
			
			pre_tableLineName = con.prepareStatement(tableLineName);
			pre_tableSiteName = con.prepareStatement(tableSiteName);
			
			pre_tableLineInfo = con.prepareStatement(tableLineInfo);
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
	public TwoLongStruct getSiteLineSeq(String sitename) {
		
		TwoLongStruct siteline = new TwoLongStruct();	// 两边站点线路序列字符串
		
		try {
			pre_viewSiteLine.setString(1, sitename);
			
			ResultSet rs = pre_viewSiteLine.executeQuery();
			
			if(rs.next()) {
				siteline.put(true, rs.getString(1));	// 保存左边线路集合字符串
				siteline.put(false, rs.getString(2));	// 保存右边线路集合字符串
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return siteline;
	}
	
	/**
	 * 获取线路站点表左行站点序列数组与右行站点序列数组
	 * @param lname
	 * 			线路名
	 * @return linesite
	 * 				线路站点枚举map（左边、右边）
	 */
	public TwoLongStruct getLineSiteSeq(String lname) {
		
		TwoLongStruct linesite = new TwoLongStruct();	// 获取两边站点线路序列字符串
		
		try {
			pre_viewLineSite.setString(1, lname);
			
			ResultSet rs = pre_viewLineSite.executeQuery();
			
			if (rs.next()) {
				linesite.put(true, rs.getString(1));	// 保存左边站点集合字符串
				linesite.put(false, rs.getString(2));	// 保存右边站点集合字符串
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return linesite;
	}

	/**
	 * 获取线路信息
	 * @param linename
	 * @return
	 */
	public ArrayStruct getLineInfo(String linename) {
		ArrayStruct lineinfo = new ArrayStruct();
		
		try {
			pre_tableLineInfo.setString(1, linename);	// 设置参数
			
			ResultSet rs = pre_tableLineInfo.executeQuery();
			
			if(rs.next()) {
				lineinfo.setLine(rs.getString(1), rs.getString(2));
				lineinfo.setTime(rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				lineinfo.setPrice(rs.getString(7), rs.getString(8));
				lineinfo.setCompany(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lineinfo;
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
			
			if(rs.next())
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
		try {
			pre_tableSiteName.setInt(1, sid);	// 设置参数
			
			ResultSet rs = pre_tableSiteName.executeQuery();
			
			if(rs.next())
				sitename = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sitename;
	}
}
