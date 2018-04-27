package com.zhiyou100.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.BlogDao;
import com.zhiyou100.dao.CategoryDao;
import com.zhiyou100.model.Bkfl;

@WebServlet("/DeleteBlogServlet")
public class DeleteBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cjr = (String) request.getSession().getAttribute("name");
		int id = Integer.parseInt(request.getParameter("id"));
		BlogDao bd = new BlogDao();
		bd.deleteBlog(id);
		CategoryDao cd = new CategoryDao();
		
		String fl = bd.getFlmc(id);
		
		int count = cd.getBwsl(cjr, fl);
		System.out.println(count);
		count = count-1;
		System.out.println(fl);
		System.out.println(count);
		cd.updateBwsl(cjr, fl, count);
		
		
		
		List<Bkfl> list = cd.selectBlogFl(cjr);
		request.getSession().setAttribute("BkflList",list);
		
		int number = bd.getBlogListCount(cjr);
		request.getSession().setAttribute("BlogListCount",number);
		response.sendRedirect("/zyblog/admin/index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
