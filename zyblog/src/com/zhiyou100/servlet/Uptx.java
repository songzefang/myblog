package com.zhiyou100.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou100.util.FileUpload;

@WebServlet("/Uptx")
public class Uptx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		FileUpload fu=new FileUpload();
		request=fu.upload(request);
		HttpSession session = request.getSession(true);

		String  tx= (String) session.getAttribute("tx");
		
		request.getSession().setAttribute("tx", tx);
		
		 PrintWriter out = response.getWriter();
		 out.print(tx);

	}

}
