package com.zhiyou100.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.zhiyou100.model.Grzl;
import com.zhiyou100.util.DButil;

public class UserDao {

	public String login(String name) {
		DButil dbutil = new DButil();
		String sql = "select * from grzl where cjr=?";
		Object[] obj = new Object[1];
		obj[0] = name;
		String ps = null;
		ResultSet rs = dbutil.search(sql, obj);
		try {
			if (rs.next()) {
				ps = rs.getString("mm");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
	
	public Grzl getUserByCjr(String name) {
		DButil dbutil = new DButil();
		String sql = "select * from grzl where cjr=?";
		Object[] obj = new Object[1];
		obj[0] = name;
		ResultSet rs = dbutil.search(sql, obj);
		Grzl grzl = new Grzl();
		try {
			if (rs.next()) {
				grzl.setNc(rs.getString("nc"));
				grzl.setZym(rs.getString("zym"));
				grzl.setTx(rs.getString("tx"));
				grzl.setYj(rs.getString("yj"));
				grzl.setJs(rs.getString("js"));
				grzl.setWb(rs.getString("wb"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grzl;
	}
	
	public int updateGrzl(String nc,String js,String tx,String zym ,String yj,String wb,String cjr) {
		DButil db = new DButil();
		String sql = "update grzl set nc = ?,js = ?,tx = ?,zym = ?,yj = ?,wb = ?,zt = ?,xgsj = ? where cjr = ?";
		System.out.println(zym);
		Object[] obj = new Object[9];
		obj[0] = nc;
		obj[1] = js;
		obj[2] = tx;
		obj[3] = zym;
		obj[4] = yj;
		obj[5] = wb;
		obj[6] = 1;
		obj[7] = new Date();
		obj[8] = cjr;
		int n = db.upDate(sql, obj);
		System.out.println("n:"+n);
		return n;
	}
	
	public void updateMm(String cjr,String mm) {
		DButil db = new DButil();
		String sql = "update grzl set mm = ? where cjr = ?";
		Object[] obj = new Object[2];
		obj[0] = mm;
		obj[1] = cjr;
		db.upDate(sql, obj);
		
	}
	
}
