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

@WebServlet("/AddBlogServlet")
public class AddBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BlogDao bd = new BlogDao();
		String fl = request.getParameter("fl");
		String bt = request.getParameter("bt");
		String zw = request.getParameter("zw");
		String fm = (String) request.getSession().getAttribute("fm");
		System.out.println("fm:"+fm);
		String cjr = (String) request.getSession().getAttribute("name");
		bd.addBlog(bt, fl, fm, zw, cjr);
		
		CategoryDao cd = new CategoryDao();
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
