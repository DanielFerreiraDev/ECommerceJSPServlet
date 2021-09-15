package br.edu.ifce.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import br.edu.ifce.beans.Produto;
import br.edu.ifce.dao.ProdutoDao;

/**
 * Servlet implementation class ProdutoController
 */
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String forward;
	private ProdutoDao produtodao;
	private int quantidade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProdutoController() {
		super();
		produtodao = new ProdutoDao();
		// TODO Auto-generated constructor stub
	}

	public static void populateBean(Object formBean, HttpServletRequest request) {
		populateBean(formBean, request.getParameterMap());
	}

	public static void populateBean(Object formBean, Map parameterMap) {

		try {
			BeanUtils.populate(formBean, parameterMap);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String app = request.getParameter("app");
		
		if(app.equalsIgnoreCase("cadastro")) {
			forward = "cadastro.jsp";		
		} else if (app.equalsIgnoreCase("adicionar")) {
			forward = "compras.jsp";
			int id = Integer.parseInt(request.getParameter("produtoId"));
			Produto produto = new Produto();
			produto = produtodao.getProdutoById(id);
			populateBean(produto, request);
			produto.setQuantidade(produto.getQuantidade() + 1);
			produtodao.updateProducts(produto);
			request.setAttribute("produtos", produtodao.getAllProducts());
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		forward = "compras.jsp";
		Produto produto = new Produto();		
		populateBean(produto, request);
		produtodao.addProducts(produto);
		
		request.setAttribute("produtos", produtodao.getAllProducts());
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
