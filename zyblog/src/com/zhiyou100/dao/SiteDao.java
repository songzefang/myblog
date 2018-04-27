package com.zhiyou100.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhiyou100.model.Sz;
import com.zhiyou100.util.DButil;

public class SiteDao {
	public int addsite(String cjr,String blogName, String keywords, String description,
			String brief, String record, String fullName) {
		this.delete(cjr);
		int ps = 0;
		DButil dbutil = new DButil();
		try {

			String sql = "insert into  sz(bkmc, ssgjc, ssms, gsjc, bah, gsqc,zt,cjr) values(?,?,?,?,?,?,?,?)";
			Object[] obj = new Object[8];
			obj[0] = blogName;
			obj[1] = keywords;
			obj[2] = description;
			obj[3] = brief;
			obj[4] = record;
			obj[5] = fullName;
			obj[6] = 1;
			obj[7] = cjr;
			ps = dbutil.upDate(sql, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
       return ps;
	}
	
	public Sz search(String cjr){
		String sql = "select * from sz where cjr = ? and zt = 1";
		DButil db = new DButil();
		Object[] obj = new Object[1];
		obj[0] = cjr;
		ResultSet rs = db.search(sql, obj);
		Sz b = new Sz();
	    try {
	    	while(rs.next()) {
			b.setBkmc(rs.getString("bkmc"));
			b.setSsgjc(rs.getString("ssgjc"));
			b.setSsms(rs.getString("ssms"));
			b.setGsjc(rs.getString("gsjc"));
			b.setBah(rs.getString("bah"));
			b.setGsqc(rs.getString("gsqc"));
			b.setZt(rs.getString("zt"));
	    	}
	    	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	public void delete(String cjr) {
		DButil db = new DButil();
		String sql = "update sz set zt = 0 where zt = 1 and cjr = ?";
		Object[] obj = {cjr};
		db.upDate(sql, obj);
	}
}
