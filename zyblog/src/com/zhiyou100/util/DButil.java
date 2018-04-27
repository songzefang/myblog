package com.zhiyou100.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DButil {
	private String url="jdbc:mysql://39.106.19.4:3306/zyblog?useUnicode=true&characterEncoding=UTF-8";
	private String user="root";
	private String password="seeliketuski1.";
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
		
	
	//加载驱动并创建连接
	public void getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("连接成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接失败！");
			e.printStackTrace();
		}
	}

	//关闭连接
	public void close(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//查询
	public ResultSet search(String sql,Object[] obj){
		this.getConnection();
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<obj.length;i++){
			try {
				ps.setObject(i+1, obj[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			rs=ps.executeQuery();
			System.out.println("查询成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//修改方法
	public int upDate(String sql,Object[] obj){
		this.getConnection();
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<obj.length;i++){
			try {
				ps.setObject(i+1, obj[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int a=0;
		try {
			a = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public ResultSet searchId(String sql){
		this.getConnection();
		Statement st = null;
		try {
			st= conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=st.executeQuery(sql);
			System.out.println("查询成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
