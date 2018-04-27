package com.zhiyou100.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.zhiyou100.dao.BlogDao;
import com.zhiyou100.model.Bkwz;

@WebServlet("/BlogList")
public class BlogList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String limit = request.getParameter("limit");
		String offset = request.getParameter("offset");
		String flmc = request.getParameter("flmc");
		String cjr = (String) request.getSession().getAttribute("name");
		BlogDao bd = new BlogDao();
		if(flmc.equals("")) {
			List<Bkwz> list = bd.getBlogList(cjr,limit,offset);
			int total = bd.getBlogListCount(cjr);
			JSONObject js = new JSONObject();
			js.put("rows", list);
			js.put("total", total);
			PrintWriter pr = response.getWriter();
			pr.print(JSONObject.toJSONString(js));
		}else {
			List<Bkwz> list = bd.getBlogList(cjr,flmc,limit,offset);
			int total = bd.getBlogListCount(cjr);
			JSONObject js = new JSONObject();
			js.put("rows", list);
			js.put("total", total);
			PrintWriter pr = response.getWriter();
			pr.print(JSONObject.toJSONString(js));
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
