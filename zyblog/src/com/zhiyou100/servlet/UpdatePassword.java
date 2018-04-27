package com.zhiyou100.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.UserDao;

@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cjr = (String) request.getSession().getAttribute("name");
		String ymm = request.getParameter("ymm");
		String xmm = request.getParameter("xmm");
		String qrmm = request.getParameter("qrmm");
		
		UserDao ud = new UserDao();
		String ps = ud.login(cjr);
		if(ps.equals(ymm)) {
			if(xmm.equals(qrmm)) {
				ud.updateMm(cjr, qrmm);
				response.setHeader("content-type", "text/html;chraset=utf-8");
				PrintWriter pw = response.getWriter();
				pw.write("<script language='javascript'>alert('修改成功');windos.location.href='admin/signin.jsp");
				response.sendRedirect("admin/signin.jsp");
			}else {
				response.setHeader("content-type", "text/html;chraset=utf-8");
				PrintWriter pw = response.getWriter();
				pw.write("<script language='javascript'>alert('两次输入的密码不一致');");
			}
		}else {
			response.setHeader("content-type", "text/html;chraset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write("<script language='javascript'>alert('密码错误');");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
