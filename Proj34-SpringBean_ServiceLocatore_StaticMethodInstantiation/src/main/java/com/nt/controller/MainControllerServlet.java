package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CirckBuzzServiceImp;

public class MainControllerServlet extends HttpServlet {
	ApplicationContext ctx=null;
@Override
public void init() throws ServletException {
	ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
}

@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	RequestDispatcher rd=null;
	try {
	//read url query string
	int matchId=Integer.parseInt(req.getParameter("mid"));
	CirckBuzzServiceImp service=ctx.getBean("service",CirckBuzzServiceImp.class);
	String result=service.getScore(matchId);
	//set result in request attribute
	req.setAttribute("result",result);
	rd=req.getRequestDispatcher("pages/show_score.jsp");
	rd.forward(req, resp);
	}
	catch(Exception e) {
		e.printStackTrace();
		rd=req.getRequestDispatcher("pages/error.jsp");
		rd.forward(req, resp);
	}
	}

@Override
	public void destroy() {
		((AbstractApplicationContext) ctx).close();
	}
}
