package com.zhiyou100.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.BlogDao;
import com.zhiyou100.model.Bkwz;

@WebServlet("/BkwzServlet")
public class BkwzServlet extends HttpServlet {
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
		String bt=request.getParameter("bt");
		BlogDao bd = new BlogDao();
		String cjr= (String) request.getSession().getAttribute("name");
		Bkwz blog=bd.getBlogBkwz(bt, cjr);
		
		int djl = BlogDao.getBlogDjl(bt, cjr);
		djl = djl+1;
		BlogDao.updateBlogDjl(djl, bt, cjr);
		
		request.setAttribute("blog", blog);
		request.getRequestDispatcher("blog.jsp").forward(request, response);
		
	}
}
