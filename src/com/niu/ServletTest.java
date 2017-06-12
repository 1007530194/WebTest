package com.niu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		/**
		 * 当多线程并发访问这个方法里面的代码时，会存在线程安全问题吗
		 * i变量被多个线程并发访问，但是没有线程安全问题，因为i是doGet方法里面的局部变量，
		 * 当有多个线程并发访问doGet方法时，每一个线程里面都有自己的i变量， 各个线程操作的都是自己的i变量，所以不存在线程安全问题
		 * 多线程并发访问某一个方法的时候，如果在方法内部定义了一些资源(变量，集合等) 那么每一个线程都有这些东西，所以就不存在线程安全问题了
		 */
		String text = (String) request.getParameter("text");

		System.out.println("结果已经传入后台：" + text);

		String output = "后台返回的结果加上前台的结果" + text;

		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
