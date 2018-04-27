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
import com.zhiyou100.dao.SiteDao;
import com.zhiyou100.dao.UserDao;
import com.zhiyou100.model.Bkfl;
import com.zhiyou100.model.Bkwz;
import com.zhiyou100.model.Grzl;
import com.zhiyou100.model.Sz;

@WebServlet("/IndexInfo")
public class IndexInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cjr = "songzefang";
		request.getSession().setAttribute("name", cjr);
		CategoryDao cd = new CategoryDao();
		List<Bkfl> list = cd.selectBlogFl(cjr);
		request.getSession().setAttribute("BkflList",list);
		
		
		SiteDao sd = new SiteDao();
		Sz sz = sd.search(cjr);
		request.getSession().setAttribute("sz",sz);
		
		UserDao ud = new UserDao();
		Grzl grzl = ud.getUserByCjr(cjr);
		System.out.println(grzl.getTx());
		request.getSession().setAttribute("grzl",grzl);
		
		BlogDao bd = new BlogDao();
		int sum = bd.getSumDjl(cjr);
		int number = bd.getBlogListCount(cjr);
		List<Bkwz> bloglist = bd.getBlogList(cjr);
		int maxPage = 0;
		int page = 1;
		if(number%5 == 0) {
			maxPage = number/5; 
		}else {
			maxPage = number/5+1;
		}
		
		request.getSession().setAttribute("Sum",sum);
		request.getSession().setAttribute("BlogList",bloglist);
		request.getSession().setAttribute("BlogListCount",number);
		request.getSession().setAttribute("MaxPage",maxPage);
		request.getSession().setAttribute("Page",page);
		
		response.sendRedirect("index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
