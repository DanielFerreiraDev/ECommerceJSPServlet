package br.edu.ifce.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifce.dao.ProdutoDao;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoDao produtodao;
	private String forward;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		produtodao = new ProdutoDao();
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
		
		String app = request.getParameter("app");
		String nomeUsuario = request.getParameter("usuario");
		String senhaUsuario = request.getParameter("senha");


		if (nomeUsuario.equals("admin") && senhaUsuario.equals("123") && app.equalsIgnoreCase("listarCompras")){
			forward = "compras.jsp";
			
			request.setAttribute("produtos", produtodao.getAllProducts());
			request.getSession().setAttribute("usuario", nomeUsuario); 
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("formLogin.html");
			// Cria um objeto que recebe solicitações do cliente e atribui o caminho fornecido 
			dispatcher.forward(request, response);
			//Encaminha um pedido de um servlet para outro recurso no servidor

		}

	}

}
