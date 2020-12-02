package br.edu.ifce;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PagMail
 */
public class PagMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = (String) request.getSession().getAttribute("userName");
		if (user == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("formLogin.jsp");
			dispatcher.forward(request, response);
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Formulário de Contato</h1>");
		out.println("<form id='emailSub' method='post' action=''>");
		out.println("<label for='fullname'>Nome completo:</label>");
		out.println("<input type='text' id='fullname' name='nomeComp' placeholder='Digite seu nome completo...'>");
		out.println("<label for='email'>E-mail:</label>");
		out.println("<input type='text' id='email' name='email' placeholder='Digite o email...'>");
		out.println("<label for='subject'>Assunto:</label>");
		out.println("<input type='text' id='subject' name='assunto' placeholder='Digite o assunto...'>");
		out.println("<label for='message'>Mensagem:</label>");
		out.println("<textarea id='message' name='mensagem'></textarea>");
		out.println("<button type='submit'>Enviar email</button");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	
		
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
