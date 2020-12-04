package br.edu.ifce.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailAuth
 */
public class MailAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomeUsuario = request.getParameter("userName");
		String senhaUsuario = request.getParameter("userPassword");
		
		if (nomeUsuario.equals("admin") && senhaUsuario.equals("123")) {
			request.getSession().setAttribute("userName", nomeUsuario);
			response.sendRedirect("PagMail");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("formLogin.jsp");
			dispatcher.forward(request, response);
		}
	}

}
