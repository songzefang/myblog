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

@WebServlet("/RemoveBkflServlet")
public class RemoveBkfl extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String bkfl_id1=request.getParameter("bkflId");
		System.out.println(bkfl_id1);
		int bkfl_id=Integer.parseInt(bkfl_id1);
		
		CategoryDao cd=new CategoryDao();
		cd.removeBkflById(bkfl_id);
		
		String cjr = (String) request.getSession().getAttribute("name");
		CategoryDao cdd = new CategoryDao();
		List<Bkfl> list = cdd.selectBlogFl(cjr);
		
		request.getSession().setAttribute("BkflList",list);
		request.getRequestDispatcher("OpenCategoryServlet").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

}
