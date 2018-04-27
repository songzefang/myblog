package com.zhiyou100.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou100.util.FileUpload;

@WebServlet("/UpCover")
public class UpCover extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				FileUpload fu=new FileUpload();
				request=fu.upload(request);
				HttpSession session = request.getSession(true);

				String  tx= (String) session.getAttribute("tx");
				
				request.getSession().setAttribute("fm", tx);
				

	}

}
