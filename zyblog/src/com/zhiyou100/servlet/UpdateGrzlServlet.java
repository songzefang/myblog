package com.zhiyou100.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.UserDao;
import com.zhiyou100.model.Grzl;

@WebServlet("/UpdateGrzlServlet")
public class UpdateGrzlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cjr = (String) request.getSession().getAttribute("name");
		String tx = (String) request.getSession().getAttribute("tx");
		String nc = request.getParameter("nc");
		String js = request.getParameter("js");
		String zym = request.getParameter("zym");
		String yj = request.getParameter("yj");
		String wb = request.getParameter("wb");
		UserDao ud = new UserDao();
		ud.updateGrzl(nc, js, tx, zym, yj, wb, cjr);
		
		Grzl g = new Grzl();
		g = ud.getUserByCjr(cjr);
		request.getSession().setAttribute("grzl", g);
		response.sendRedirect("admin/profile.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
