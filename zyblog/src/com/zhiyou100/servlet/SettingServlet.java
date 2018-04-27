package com.zhiyou100.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.SiteDao;

public class SettingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogName = request.getParameter("blogName");
		String keywords = request.getParameter("keywords");
		String description = request.getParameter("description");
		String brief = request.getParameter("brief");
		String record = request.getParameter("record");
		String fullName = request.getParameter("fullName");
		String cjr = (String) request.getSession().getAttribute("name");
		SiteDao sitedao = new SiteDao();
		sitedao.addsite(cjr,blogName, keywords, description, brief, record, fullName);
		request.getSession().setAttribute("sz", sitedao.search(cjr));
		request.getRequestDispatcher("/SetingList").forward(request, response);
		
		

	}

}
