package br.edu.ifpb.projetopwebii.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RealizaLogin
 */
@WebServlet("/login.do")
public class RealizaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizaLogin() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		/*
		String login = request.getParameter("inputLogin");
		String senha = request.getParameter("inputPassword");
		
		ListIterator iterator = usuarios.listIterator();
		while(iterator.hasNext()){
			Usuario u  = (Usuario) iterator.next();
			if(u.getLogin() == login && u.getSenha() == senha){
				RequestDispatcher d = request.getRequestDispatcher("Calendario.jsp");
				d.forward(request, response);
			}
			
		}*/
	}

}
