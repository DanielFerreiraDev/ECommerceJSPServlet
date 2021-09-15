package br.edu.ifce.aula01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Aula01_2
 */
public class Aula01_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**  
     * @see HttpServlet#HttpServlet()
     */
    public Aula01_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("usuario");
		Enumeration parametros = request.getParameterNames();
		request.getParameterValues("usuario");
		
		out.println("<html>");
		out.println("<body>");
			out.println("<h1><center>Meu primeiro Servlet</center></h1><br>");
			if(nome != null) {
				out.println("<h2>Nome de usuário:" + parametros + "</h2>");
			}
		out.println("</body>");
		out.println("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
