package com.kapx.wildfly.javaee7.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kapx.wildfly.javaee7.ejb.HelloWorldLocal;

@WebServlet(name = "ApplicationServlet", urlPatterns = "/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationServlet.class);

	@EJB
	private HelloWorldLocal helloWorldEJB;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("ApplicationServlet doGet() method invoked...");
		final PrintWriter out = response.getWriter();
		out.write("ApplicationServlet doGet() method invoked...");

		final String result = helloWorldEJB.sayHello("WildFly");
		LOG.info("Result of HelloWorldBean invocation is {}", result);
		out.write(result);

		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
