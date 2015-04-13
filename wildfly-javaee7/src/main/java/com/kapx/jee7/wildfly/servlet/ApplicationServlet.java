package com.kapx.jee7.wildfly.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
@WebServlet(name = "ApplicationServlet", urlPatterns = "/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServlet.class);

	@Override
	public void init() throws ServletException {
		LOGGER.info("Application Servlet initialized...");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final PrintWriter out = response.getWriter();
		out.print("Application Servlet invoked...");
		out.close();

		LOGGER.info("Application Servlet invoked...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void destroy() {
		LOGGER.info("Application Servlet destroyed...");
	}
}
