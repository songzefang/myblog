package com.zhiyou100.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou100.dao.BlogDao;
import com.zhiyou100.model.Bkwz;

@WebServlet("/SelectBlogServlet")
public class SelectBlogServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String bt="%"+request.getParameter("select")+"%";
		System.out.println(bt);
		HttpSession session = request.getSession();
		String cjr=(String) request.getSession().getAttribute("name");
		List<Bkwz> list = new ArrayList<Bkwz>();
		list=BlogDao.getBlog(bt,cjr);
		session.setAttribute("blogList", list);
		System.out.println(list);
		int count = BlogDao.getBlogCount(bt,cjr);
		int maxPage = 0;
		int page = 1;
		if(count%5 == 0) {
			maxPage = count/5; 
		}else {
			maxPage = count/5+1;
		}
		request.getSession().setAttribute("MaxPage", maxPage);
		request.getSession().setAttribute("Page", page);
		request.getSession().setAttribute("BlogList", list);
		response.sendRedirect("index.jsp");
		}

	
}
