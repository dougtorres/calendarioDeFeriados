package br.edu.ifpb.projetopwebii.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.projetopwebii.dao.DAO;
import br.edu.ifpb.projetopwebii.dao.UsuarioDAO;
import br.edu.ifpb.projetopwebii.model.Admin;
import br.edu.ifpb.projetopwebii.model.Usuario;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/controller.do")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		switch(request.getParameter("op")){
		

			
		
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getParameter("op")) {
		case "cadastra":
			cadastrarUsuario(request, response);
			break;

		case "login":
			realizarLogin(request, response);
			break;
			
		case "criaadm":
			criaAdm(request, response);
			break;
		}

	}

	protected void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		String resultado = "Usuário Cadastrado Com Sucesso!";
		request.setAttribute("resultado", resultado);
		RequestDispatcher d = request.getRequestDispatcher("cadastro.jsp");
		d.forward(request, response);

	}

	protected void realizarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String login = null;
		String senha = null;
		String resultado;
		if(!request.getParameter("loginLogin").isEmpty() || !request.getParameter("loginSenha").isEmpty()){
			
			login = request.getParameter("loginLogin");
			senha = request.getParameter("loginSenha");
			
		}else{
			resultado = "Preencha todos os campos";
			request.setAttribute("resultado", resultado);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		DAO.open();
		UsuarioDAO dao = new UsuarioDAO();
		Usuario u = dao.getUsuarioByLogin(login, senha);
		dao.close();
		if(u == null){
			
			resultado = "Esse usuário não existe!";
			request.setAttribute("resultado", resultado);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("usuario", u);
			session.setAttribute("status", "logado");
			if(u.isAdmin() == true)
			request.getRequestDispatcher("dashboard-administrador.jsp").forward(request, response);
			else
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}

	}
	
	protected void criaAdm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = "Douglas";
		String login = "adm";
		String senha = "adm";
		Admin u = new Admin(nome, login, senha);
		UsuarioDAO dao = new UsuarioDAO();
		dao.open();
		dao.begin();
		dao.create(u);
		dao.commit();
		dao.close();

	}

}
