package com.zhiyou100.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhiyou100.model.Bkwz;
import com.zhiyou100.util.DButil;

public class BlogDao {

	public void addBlog(String bt, String fl, String fm, String zw, String cjr) {
		String sql = "insert into bkwz (bt,fl,fm,zw,sfzd,zt,cjr,cjsj,xgsj) value(?,?,?,?,?,?,?,?,?)";
		Object[] obj = new Object[9];
		obj[0] = bt;
		obj[1] = fl;
		obj[2] = fm;
		obj[3] = zw;
		obj[4] = 0;
		obj[5] = 1;
		obj[6] = cjr;
		obj[7] = new Date();
		obj[8] = new Date();
		DButil db = new DButil();
		db.upDate(sql, obj);

		CategoryDao cd = new CategoryDao();
		int number = cd.getBwsl(cjr, fl);
		number = number + 1;
		cd.updateBwsl(cjr, fl, number);

	}

	public List<Bkwz> getBlogList(String cjr, String limit, String offset) {
		String sql = "select * from bkwz where cjr = ? and zt = 1  order by sfzd DESC limit " + offset + ", " + limit;
		Object obj[] = new Object[1];
		obj[0] = cjr;
		DButil db = new DButil();
		ResultSet rs = db.search(sql, obj);
		List<Bkwz> list = new ArrayList<Bkwz>();
		try {
			while (rs.next()) {
				Bkwz b = new Bkwz();
				b.setId(rs.getString("id"));
				b.setBt(rs.getString("bt"));
				b.setFl(rs.getString("fl"));
				b.setCjsj(rs.getDate("cjsj"));
				b.setDjl(rs.getInt("djl"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Bkwz> getBlogList(String cjr) {

		String sql = "select * from bkwz where cjr = ? and zt = 1";
		Object obj[] = new Object[1];
		obj[0] = cjr;
		DButil db = new DButil();
		ResultSet rs = db.search(sql, obj);
		List<Bkwz> list = new ArrayList<Bkwz>();
		try {
			while (rs.next()) {
				Bkwz b = new Bkwz();
				b.setId(rs.getString("id"));
				b.setBt(rs.getString("bt"));
				b.setFm(rs.getString("fm"));
				b.setZw(rs.getString("zw"));
				b.setFl(rs.getString("fl"));
				b.setDjl(rs.getInt("djl"));
				b.setCjsj(rs.getDate("cjsj"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Bkwz> getBlogList(String cjr, String flmc) {

		String sql = "select * from bkwz where cjr = ? and fl = ? and zt = 1";
		Object obj[] = new Object[2];
		obj[0] = cjr;
		obj[1] = flmc;
		DButil db = new DButil();
		ResultSet rs = db.search(sql, obj);
		List<Bkwz> list = new ArrayList<Bkwz>();
		try {
			while (rs.next()) {
				Bkwz b = new Bkwz();
				b.setId(rs.getString("id"));
				b.setBt(rs.getString("bt"));
				b.setFm(rs.getString("fm"));
				b.setZw(rs.getString("zw"));
				b.setFl(rs.getString("fl"));
				b.setDjl(rs.getInt("djl"));
				b.setCjsj(rs.getDate("cjsj"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Bkwz> getBlogList(String cjr, String flmc, String limit, String offset) {
		String sql = "select * from bkwz where cjr = ? and zt = 1 and fl = ? order by sfzd DESC limit " + offset + ", "
				+ limit;
		Object obj[] = new Object[2];
		obj[0] = cjr;
		obj[1] = flmc;
		DButil db = new DButil();
		ResultSet rs = db.search(sql, obj);
		List<Bkwz> list = new ArrayList<Bkwz>();
		try {
			while (rs.next()) {
				Bkwz b = new Bkwz();
				b.setId(rs.getString("id"));
				b.setBt(rs.getString("bt"));
				b.setFl(rs.getString("fl"));
				b.setCjsj(rs.getDate("cjsj"));
				b.setDjl(rs.getInt("djl"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int getBlogListCount(String cjr) {
		String sql = "select count(*) as count from bkwz where cjr = ? and zt = 1";
		int count = 0;
		Object obj[] = new Object[1];
		obj[0] = cjr;
		DButil db = new DButil();
		ResultSet rs = db.search(sql, obj);
		try {
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public int getBlogListCount(String cjr, String flmc) {
		String sql = "select count(*) as count from bkwz where cjr = ? and fl=? and zt = 1";
		int count = 0;
		Object obj[] = new Object[2];
		obj[0] = cjr;
		obj[1] = flmc;
		DButil db = new DButil();
		ResultSet rs = db.search(sql, obj);
		try {
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public void blogZd(int id) {
		String sql = "update bkwz set sfzd = 1 where id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		DButil db = new DButil();
		db.upDate(sql, obj);
	}

	public void blogQxzd(String cjr) {
		String sql = "update bkwz set sfzd = 0 where cjr = ? and sfzd = 1";
		Object[] obj = new Object[1];
		obj[0] = cjr;
		DButil db = new DButil();
		db.upDate(sql, obj);
	}

	public void deleteBlog(int id) {
		String sql = "update bkwz set zt = 0 where id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		DButil db = new DButil();
		db.upDate(sql, obj);

	}

	public int isZd(int id) {
		int sfzd = 0;
		String sql = "select sfzd from bkwz where id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		DButil db = new DButil();
		ResultSet rs = db.search(sql, obj);
		try {
			if (rs.next()) {
				sfzd = Integer.parseInt(rs.getString("sfzd"));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sfzd;
	}

	public int selectBlogSfzd(String cjr) {
		int zd = 0;
		String sql = "select count(*) as count from bkwz where cjr = ?";
		Object[] obj = new Object[1];
		obj[0] = cjr;
		DButil db = new DButil();
		ResultSet rs = db.search(sql, obj);
		try {
			if (rs.next()) {
				zd = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zd;
	}

	public String getFlmc(int id) {
		String sql = "select fl from bkwz where id = ?";
		String fl = "";
		Object[] obj = new Object[1];
		obj[0] = id;
		DButil db = new DButil();
		ResultSet rs = db.search(sql, obj);
		try {
			if (rs.next()) {
				fl = rs.getString("fl");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fl;
	}

	public static int getBlogCount(String bt, String cjr) {
		DButil dbUtil = new DButil();
		String sql = "select count(*) from bkwz where zt=1 and cjr=? and bt like ?";
		Object[] obj = new Object[2];
		obj[0] = cjr;
		obj[1] = bt;
		ResultSet rs = dbUtil.search(sql, obj);
		int count = 0;
		try {
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public static ArrayList<Bkwz> getBlog(String bt, String cjr) {
		DButil dbUtil = new DButil();
		String sql = "select * from bkwz where zt=1 and cjr=? and bt like ? order by sfzd";
		Object[] obj = new Object[2];
		obj[0] = cjr;
		obj[1] = bt;
		System.out.println(obj[1]);
		ResultSet rs = dbUtil.search(sql, obj);
		ArrayList<Bkwz> list = new ArrayList<Bkwz>();
		try {
			while (rs.next()) {
				Bkwz b = new Bkwz();
				b.setId(rs.getString("id"));
				b.setBt(rs.getString("bt"));
				b.setFm(rs.getString("fm"));
				b.setZw(rs.getString("zw"));
				b.setFl(rs.getString("fl"));
				b.setCjsj(rs.getDate("cjsj"));
				b.setDjl(rs.getInt("djl"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static int getBlogDjl(String bt, String cjr) {
		DButil dbUtil = new DButil();
		String sql = "select djl from bkwz where zt=1 and bt=? and cjr=?";
		Object[] obj = new Object[2];
		obj[0] = bt;
		obj[1] = cjr;
		ResultSet rs = dbUtil.search(sql, obj);
		int count = 0;
		try {
			if (rs.next()) {
				count = rs.getInt("djl");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public static int updateBlogDjl(int djl, String bt, String cjr) {
		DButil dbUtil = new DButil();
		Object[] obj = new Object[3];
		obj[0] = djl;
		obj[1] = bt;
		obj[2] = cjr;
		String sql = "update bkwz set djl=? where bt=? and cjr=?";
		return dbUtil.upDate(sql, obj);
	}

	public Bkwz getBlogBkwz(String bt, String cjr) {
		DButil dbUtil = new DButil();
		String sql = "select * from bkwz where zt=1 and bt=? and cjr=?";
		Object[] obj = new Object[2];
		obj[0] = bt;
		obj[1] = cjr;
		ResultSet rs = dbUtil.search(sql, obj);
		Bkwz blog = new Bkwz();
		try {
			if (rs.next()) {
				blog.setBt(rs.getString("bt"));
				blog.setFl(rs.getString("fl"));
				blog.setFm(rs.getString("fm"));
				blog.setZw(rs.getString("zw"));
				blog.setDjl(rs.getInt("djl"));
				blog.setCjsj(rs.getDate("cjsj"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blog;
	}

	public int getSumDjl(String cjr) {
		int sum=0;
		String sql = "select sum(djl) as sum from bkwz where cjr = ? and zt = 1";
		DButil dbUtil = new DButil();
		Object[] obj = new Object[1];
		obj[0] = cjr;
		ResultSet rs = dbUtil.search(sql, obj);
		try {
			if(rs.next()) {
				sum = rs.getInt("sum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum;
	}
}
