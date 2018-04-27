package com.zhiyou100.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.BlogDao;
import com.zhiyou100.model.Bkwz;

@WebServlet("/BlogListQt")
public class BlogListQt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flmc = request.getParameter("flmc");
		String cjr = (String) request.getSession().getAttribute("name");
		BlogDao bd = new BlogDao();
		System.out.println("flmc:"+flmc);
		int number = bd.getBlogListCount(cjr, flmc);
		List<Bkwz> list = bd.getBlogList(cjr, flmc);
		int maxPage = 0;
		int page = 1;
		if(number%5 == 0) {
			maxPage = number/5; 
		}else {
			maxPage = number/5+1;
		}
		request.getSession().setAttribute("MaxPage", maxPage);
		request.getSession().setAttribute("Page", page);
		request.getSession().setAttribute("BlogList", list);
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
