package com.zhiyou100.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.CategoryDao;
import com.zhiyou100.model.Bkfl;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flmc = request.getParameter("flmc");
		String flms = request.getParameter("flms");
		String bwsl = "0";
		String zt = "1";
		String cjr = (String) request.getSession().getAttribute("name");
		CategoryDao cd = new CategoryDao();
		cd.add(flmc, flms, bwsl, zt, cjr);
		
		List<Bkfl> list = cd.selectBlogFl(cjr);
		request.getSession().setAttribute("BkflList",list);
		
		request.getRequestDispatcher("/OpenCategoryServlet").forward(request, response);
		
	}

}
