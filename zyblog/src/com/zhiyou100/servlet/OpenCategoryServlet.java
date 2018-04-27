package com.zhiyou100.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.CategoryDao;
import com.zhiyou100.model.Bkfl;

@WebServlet("/OpenCategoryServlet")
public class OpenCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cjr = (String) request.getSession().getAttribute("name");
		CategoryDao cd = new CategoryDao();
		ArrayList<Bkfl> list = cd.search(cjr);
		request.setAttribute("info", list);
		request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
		
	}

}
