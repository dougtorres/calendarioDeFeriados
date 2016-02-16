package br.edu.ifpb.projetopwebii.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.projetopwebii.dao.UsuarioDAO;
import br.edu.ifpb.projetopwebii.model.Usuario;

/**
 * Servlet implementation class CadastraUser
 */
@WebServlet("/cadastrauser.do")
public class CadastraUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastraUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("password");
		Usuario u = new Usuario(nome, login, senha);
		UsuarioDAO dao = new UsuarioDAO();
		dao.open();
		dao.begin();
		dao.create(u);
		dao.commit();
		dao.close();
		
		RequestDispatcher d = request.getRequestDispatcher("Calendario.jsp");
		d.forward(request, response);
		
	}

}
