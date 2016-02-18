package br.edu.ifpb.projetopwebii.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;

import com.google.gson.Gson;

import br.edu.ifpb.projetopwebii.dao.DAO;
import br.edu.ifpb.projetopwebii.dao.FeriadoDAO;
import br.edu.ifpb.projetopwebii.dao.UsuarioDAO;
import br.edu.ifpb.projetopwebii.model.Admin;
import br.edu.ifpb.projetopwebii.model.Calendario;
import br.edu.ifpb.projetopwebii.model.Feriado;
import br.edu.ifpb.projetopwebii.model.Usuario;
import br.edu.ifpb.pwebprojeto.util.TipoFeriado;

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
		
		case "getEventos":
			getEventos(request, response);
			break;
			

			
		
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
			
		case "addFeriadoFixo":
			try {
				addFeriadoFixo(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	protected void getEventos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Calendario> listaCalendario = new ArrayList<Calendario>();

		Calendario c = new Calendario();
		List<Feriado> lista;
		FeriadoDAO dao = new FeriadoDAO();
		dao.open();
		lista = dao.readAll();
		dao.close();
		Iterator itr = lista.iterator();
		while(itr.hasNext()){
			Feriado f = (Feriado) itr.next();
			if(f.getTipo() == TipoFeriado.Fixo){
				c.setId(f.getId());
				c.setTitle(f.getTitulo());
				System.out.println(f.getInicio());
				c.setStart(f.getInicio());
				c.setEnd(f.getFim());
				c.setTipo(f.getTipo());
				listaCalendario.add(c);
			}
			
		}
			
			System.out.println(c.getStart());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(new Gson().toJson(listaCalendario));
		
	}
	
		
		
		protected void attFeriadosFixos(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, ParseException {
			ArrayList<Calendario> listaCalendario = new ArrayList<Calendario>();
			String ano = request.getParameter("ano");
			ano = ano.substring(0, 4);	
			System.out.println(ano);
			Calendario c = new Calendario();
			List<Feriado> lista;
			FeriadoDAO dao = new FeriadoDAO();
			dao.open();
			lista = dao.readAll();
			
			Iterator itr = lista.iterator();
			while(itr.hasNext()){
				Feriado f = (Feriado) itr.next();
				if(f.getTipo() == TipoFeriado.Fixo){
					c.setId(f.getId());
					c.setTitle(f.getTitulo());
					c.setStart(ano+"-"+f.getDiaMesInicio());
					c.setEnd(ano+"-"+f.getDiaMesFim());
					c.setTipo(f.getTipo());
					f.setInicio(c.getStart());
					f.setFim(c.getEnd());
					dao.begin();
					dao.update(f);
					dao.commit();
	
					listaCalendario.add(c);
				}
				
				dao.close();
				
			}

	}
	
	protected void addFeriadoFixo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String resultado;
		String titulo = request.getParameter("tituloFeriado");
		String inicio = request.getParameter("inicioFeriado");
		String fim = request.getParameter("fimFeriado");
		Feriado f = new Feriado(titulo, inicio, fim, TipoFeriado.Fixo);
		FeriadoDAO dao = new FeriadoDAO();
		dao.open();
		dao.begin();
		dao.create(f);
		dao.commit();
		dao.close();

		resultado = "Feriado Fixo Cadastrado Com Sucesso!";
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("cadastrar-feriado-fixo.jsp").forward(request, response);
	}

}
