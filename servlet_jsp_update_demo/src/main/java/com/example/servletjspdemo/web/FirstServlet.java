package com.example.servletjspdemo.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FirstServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		response.setContentType("text/html");
		response.getWriter().println("<h1>hello "+name+"</h1>");
		HttpSession session = request.getSession();
		ServletContext ctx = request.getServletContext();
		if(name!=null&&!name.equalsIgnoreCase(""))
			{
				session.setAttribute("name", name);
				ctx.setAttribute("name", name);
			}

		response.getWriter().println("<h1>hello from session "+session.getAttribute("name")+"</h1>");
		response.getWriter().println("<h1>hello from contgext "+ctx.getAttribute("name")+"</h1>");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
