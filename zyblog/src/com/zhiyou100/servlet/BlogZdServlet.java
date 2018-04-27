package com.zhiyou100.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.BlogDao;

@WebServlet("/BlogZdServlet")
public class BlogZdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String cjr = (String) request.getSession().getAttribute("name");
		BlogDao bd = new BlogDao();
		if(bd.isZd(id) == 0) {
			if(bd.selectBlogSfzd(cjr) == 0) {
				bd.blogZd(id);
			}else {
				bd.blogQxzd(cjr);
				bd.blogZd(id);
			}
		}else {
			bd.blogQxzd(cjr);
		}
		response.sendRedirect("/zyblog/admin/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
