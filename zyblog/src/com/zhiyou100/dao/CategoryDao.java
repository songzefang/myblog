package com.zhiyou100.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhiyou100.model.Bkfl;
import com.zhiyou100.util.DButil;

public class CategoryDao {
	public int add(String flmc,String flms,String bwsl,String zt,String cjr) {
		int ps = 0;
		Date date = new Date();
		DButil dbutil = new DButil();
		try {
			String sql = "insert into bkfl(flmc,flms,bwsl,px,zt,cjr,cjsj) values(?,?,?,?,?,?,?)";
			Object[] obj = new Object[7];
			obj[0] = flmc;
			obj[1] = flms;
			obj[2] = bwsl;
			obj[3] = this.getPx();
			obj[4] = zt;
			obj[5] = cjr;
			obj[6] = date;
			ps = dbutil.upDate(sql, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
       return ps;	
	}
	
	public String getPx() {
		String sql = "select max(id) as px from bkfl";
		DButil db= new DButil();
		ResultSet rs = db.searchId(sql);
		String px = "0";
		int num;
		try {
			if(rs.next()) {
				px = rs.getString("px");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(px == null) {
			return "1";
		}
		num = Integer.parseInt(px);
		num = num+1;
		px = String.valueOf(num);
		return px;
	}
	 
	
	public  ArrayList<Bkfl> search(String cjr){
		String sql = "select * from bkfl where cjr = ? and zt = 1 order by px";
		DButil db = new DButil();
		Object[] obj = new Object[1];
		obj[0] = cjr;
		ResultSet rs = db.search(sql, obj);   
		ArrayList<Bkfl> list = new ArrayList<Bkfl>();
		try {
			while(rs.next()) {
				Bkfl b = new Bkfl();
				b.setId(Integer.parseInt(rs.getString("id")));
				b.setPx(rs.getString("px"));
				b.setFlmc(rs.getString("flmc"));
				b.setFlms(rs.getString("flms")); 
				list.add(b);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return list;
		
	}
	
	public List<Bkfl> selectBlogFl(String cjr){
		String sql = "select flmc ,bwsl from bkfl where cjr = ? and zt = 1 order by px";
		Object[] obj = new Object[1];
		obj[0] = cjr;
		DButil db = new DButil();
		ResultSet rs = db.search(sql, obj);
		List<Bkfl> list = new ArrayList<Bkfl>();
		try {
			while(rs.next()) {
				Bkfl b = new Bkfl();
				b.setFlmc(rs.getString("flmc"));
				b.setBwsl(rs.getInt("bwsl"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
	}
	
	public void removeBkflById(int id) {
		// TODO Auto-generated method stub
		String sql="update bkfl set zt=0 where id=?";
		Object[] obj={id};
		DButil db = new DButil();
		db.upDate(sql, obj);
		
	}
	
	public void update(int id,int px) {
		String sql = "update bkfl set px = ? where id = ?";
		Object[] obj = new Object[2];
		obj[0] = px;
		obj[1] = id;
		DButil db = new DButil();
		db.upDate(sql, obj);
	}
	
	public int getBwsl(String cjr,String flmc) {
		int number = 0;
		String sql = "select bwsl from bkfl where cjr = ? and flmc = ?";
		Object[] obj = new Object[2];
		obj[0] = cjr;
		obj[1] = flmc;
		DButil db = new DButil();
		ResultSet rs = db.search(sql, obj);
		try {
			if(rs.next()) {
				number = rs.getInt("bwsl");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
	
	public void updateBwsl(String cjr ,String flmc, int bwsl) {
		String sql = "update bkfl set bwsl = ? where flmc = ? and cjr = ?";
		Object[] obj = new Object[3];
		obj[0] = bwsl;
		obj[1] = flmc;
		obj[2] = cjr;
		DButil db = new DButil();
		db.upDate(sql, obj);
	}
	
}
