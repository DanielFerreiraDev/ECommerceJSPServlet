package br.edu.ifce.aula01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String nomeUsuario = request.getParameter("usuario");

		String senhaUsuario = request.getParameter("senha");

		PrintWriter out = response.getWriter();

		if (nomeUsuario.equals("admin") && senhaUsuario.equals("123")){
			
			request.getSession().setAttribute("usuario", nomeUsuario); 
			//Retorna o HTTPSession e vincula o objeto a essa sessão
			response.sendRedirect("email.jsp"); 
			//Envia uma resposta para redirecionar ao cliente usando essa URL
			
		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("formlogin.html");
			// Cria um objeto que recebe solicitações do cliente e atribui o caminho fornecido 
			dispatcher.forward(request, response);
			//Encaminha um pedido de um servlet para outro recurso no servidor

		}

	}

}
