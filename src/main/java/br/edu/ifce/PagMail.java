package br.edu.ifce;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

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
		out.println("<head>");
		out.println("<title>Enviar Email</title>");
		out.println("<link rel='stylesheet' href='Main.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<header>");
		out.println("<h1 id='title'>Formulário de Contato</h1>");
		out.println("</header>");
		out.println("<form id='mailForm' method='post' action='PagMail'>");
		out.println("<div class='input-group'>");
		out.println("<label for='fullname'>Nome completo:</label>");
		out.println("<input type='text' id='fullname' name='nomeComp' placeholder='Digite seu nome completo...'>");
		out.println("</div>");
		out.println("<div class='input-group'>");
		out.println("<label for='email'>E-mail:</label>");
		out.println("<input type='text' id='email' name='email' placeholder='Digite o email...'>");
		out.println("</div>");
		out.println("<div class='input-group'>");
		out.println("<label for='subject'>Assunto:</label>");
		out.println("<input type='text' id='subject' name='assunto' placeholder='Digite o assunto...'>");
		out.println("</div>");
		out.println("<div class='input-group'>");
		out.println("<label for='message'>Mensagem:</label>");
		out.println("<textarea id='message' name='mensagem'></textarea>");
		out.println("</div>");
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
		String fullName = request.getParameter("nomeComp");
		String mailTo = request.getParameter("email");
		String subject = request.getParameter("assunto");
		String message = request.getParameter("mensagem");
		
		SimpleEmail email = new SimpleEmail();  

	    try {  
	     email.setDebug(true);  
	     email.setHostName("smtp.gmail.com");  
	     email.setAuthentication(null, null);  // Coloque aqui o email para a autenticação
	     email.setSSLOnConnect(true);  
	     email.addTo(mailTo); //pode ser qualquer email  
	     email.setFrom(""); //será passado o email que você fará a autenticação
	     email.setSubject(subject);  
	     email.setMsg("Mensagem de: " + fullName + " " + message);  
	     email.send();  

	     } catch (EmailException e) {  

	     System.out.println(e.getMessage());  

	      }   
	}

}
