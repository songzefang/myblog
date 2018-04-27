package com.zhiyou100.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.CategoryDao;

@WebServlet("/UpdateDownServlet")
public class UpdateDown extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String myid1 = request.getParameter("myid");
		String mypx1 = request.getParameter("mypx");
		String downid1 = request.getParameter("downid");
		String downpx1 = request.getParameter("downpx");
		int myid = Integer.parseInt(myid1);
		int mypx = Integer.parseInt(mypx1);
		CategoryDao cd = new CategoryDao();
		int downid = Integer.parseInt(downid1);
		int downpx = Integer.parseInt(downpx1);
		cd.update(myid, downpx);
		cd.update(downid, mypx);
		request.getRequestDispatcher("OpenCategoryServlet").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
