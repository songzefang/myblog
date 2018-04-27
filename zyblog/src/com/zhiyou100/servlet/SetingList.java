package com.zhiyou100.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.SiteDao;
import com.zhiyou100.model.Sz;

@WebServlet("/SetingList")
public class SetingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cjr = (String) request.getSession().getAttribute("name");
		SiteDao sd = new SiteDao();
		Sz s = sd.search(cjr);
		request.setAttribute("info", s);
		request.getRequestDispatcher("/admin/setting.jsp").forward(request, response);
		
	}

}
