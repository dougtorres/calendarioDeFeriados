package br.edu.ifpb.pwebprojeto.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.edu.ifpb.pwebprojeto.dao.DAO;
import br.edu.ifpb.pwebprojeto.dao.FeriadoDAO;
import br.edu.ifpb.pwebprojeto.dao.NotaDAO;
import br.edu.ifpb.pwebprojeto.dao.UsuarioDAO;
import br.edu.ifpb.pwebprojeto.model.Admin;
import br.edu.ifpb.pwebprojeto.model.Calendario;
import br.edu.ifpb.pwebprojeto.model.Feriado;
import br.edu.ifpb.pwebprojeto.model.Nota;
import br.edu.ifpb.pwebprojeto.model.Usuario;
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
			
		case "addFeriadoSubstituto":
			addFeriadoSubstituto(request, response);
			break;
		case "alteraFeriadoJSP":
			try {
				alteraFeriadoJSP(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "excluirFeriado":
			try {
				excluirFeriado(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "adicionarNotaJSP":
			try {
				adicionarNotaJSP(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "getNotas":
			getNotas(request, response);
			break;
		case "alterarNotaJSP":
			try {
				alterarNotaJSP(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		
		case "logout":
			try {
				logout(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "alterarUsuario":
			try {
				alterarUsuario(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "listarUsuarios":
			listarUsuarios(request, response);
			break;
			
		case "excluirNota":
			try {
				excluirNota(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "excluirUsuario":
			try {
				excluirUsuario(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "excluirUsuarioAdm":
			try {
				excluirUsuarioAdm(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "adicionarNota":
			try {
				adicionarNota(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		case "addFeriadoFixoSubstituto":
			try {
				adcFeriadoSubstituto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "addFeriadoMovel":
			try {
				addFeriadoMovel(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case "alteraFeriado":
	
				try {
					alteraFeriado(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			break;
		case "adicionarNota":
			try {
				adicionarNota(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "alterarNota":
			try {
				alterarNota(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "alterar_usuario":
			alterar_Usuario(request, response);
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
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.open();
		dao.begin();
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
	
	protected void addFeriadoSubstituto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Feriado> lista;
		ArrayList<Feriado> feriadosFixos = new ArrayList<Feriado>();
		FeriadoDAO dao = new FeriadoDAO();
		dao.open();
		lista = dao.readAll();
		dao.close();
		for(Feriado f: lista){
			
			if(f.getTipo() == TipoFeriado.Fixo){
				
				Feriado aux = f;
				feriadosFixos.add(aux);
				
				}
				
			}
		request.setAttribute("feriadosFixos", feriadosFixos);
		request.getRequestDispatcher("cadastrar-feriado-substituto.jsp").forward(request, response);
		}
	
	protected void getEventos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Calendario> listaCalendario = new ArrayList<Calendario>();
		
		
		Calendar cal = Calendar.getInstance();
		
		int ano = cal.get(Calendar.YEAR) - 30;
		List<Feriado> lista;
		FeriadoDAO dao = new FeriadoDAO();
		dao.open();
		dao.begin();
		lista = dao.readAll();
		dao.close();
		Iterator itr = lista.iterator();
		while(itr.hasNext()){
			Feriado f = (Feriado) itr.next();
			if(f.getTipo() == TipoFeriado.Substituto){
				String anoSub = f.getAnoSubstituto();
				Calendario c = new Calendario();
				c.setId(f.getId());
				c.setTitle(f.getTitulo());
				c.setStart(f.getInicioSubstituto());
				c.setEnd(f.getFimSubstituto());
				c.setTipo(f.getTipo());
				c.setColor(f.getCor());
				listaCalendario.add(c);
				for(int i=0; i <= 70; i++){
					
				if(ano != Integer.parseInt(anoSub)){
				Calendario c2 = new Calendario();
				c2.setId(f.getId());
				c2.setTitle(f.getTitulo());
				c2.setStart(Integer.toString(ano)+"-"+f.getDiaMesInicio());
				c2.setEnd(Integer.toString(ano)+"-"+f.getDiaMesFim());
				c2.setTipo(f.getTipo());
				c2.setColor(f.getCor());
				listaCalendario.add(c2);
				ano++;}
				else
					ano++;
				}
				
			ano =  cal.get(Calendar.YEAR) - 30;
				
				
			}if(f.getTipo() == TipoFeriado.Fixo){
				
				for(int i=0; i <= 60; i++){
				Calendario c = new Calendario();
				c.setId(f.getId());
				c.setTitle(f.getTitulo());
				c.setStart(Integer.toString(ano)+"-"+f.getDiaMesInicio());
				c.setEnd(Integer.toString(ano)+"-"+f.getDiaMesFim());
				c.setColor(f.getCor());
				c.setTipo(f.getTipo());
				listaCalendario.add(c);
				ano++;
				}
				
			ano =  cal.get(Calendar.YEAR) - 30;
			}if(f.getTipo() == TipoFeriado.Movel){
			
				Calendario c = new Calendario();
				c.setId(f.getId());
				c.setTitle(f.getTitulo());
				c.setStart(f.getInicio());
				c.setEnd(f.getFim());
				c.setTipo(f.getTipo());
				c.setColor(f.getCor());
				listaCalendario.add(c);
				
				}

			
		}
			
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(new Gson().toJson(listaCalendario));
		
	}
	
		
	protected void addFeriadoFixo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String resultado;
		String titulo = request.getParameter("tituloFeriado");
		String inicio = request.getParameter("inicioFeriado");
		String fim = request.getParameter("fimFeriado");
		Feriado f = new Feriado(titulo, inicio, fim, TipoFeriado.Fixo);
		f.setCor("#c36969");
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
	
	
	protected void addFeriadoMovel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String resultado;
		String titulo = request.getParameter("tituloFeriadoMovel");
		String inicio = request.getParameter("inicioFeriadoMovel");
		String fim = request.getParameter("fimFeriadoMovel");
		Feriado f = new Feriado(titulo, inicio, fim, TipoFeriado.Movel);
		f.setCor("#7269c3");
		FeriadoDAO dao = new FeriadoDAO();
		dao.open();
		dao.begin();
		dao.create(f);
		dao.commit();
		dao.close();

		resultado = "Feriado Móvel Cadastrado Com Sucesso!";
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("cadastrar-feriado-movel.jsp").forward(request, response);
	}
	protected void adcFeriadoSubstituto(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String resultado;
		String id = request.getParameter("feriadoSubstituto");
		String inicio = request.getParameter("inicioFeriadoSubstituto");
		String fim = request.getParameter("fimFeriadoSubstituto");
		System.out.println(inicio);
		FeriadoDAO dao = new FeriadoDAO();
		dao.open();
		dao.begin();
		Feriado aux = dao.read(id);
		aux.setInicioSubstituto(inicio);
		aux.setFimSubstituto(fim);
		aux.setTipo(TipoFeriado.Substituto);
		aux.setCor("#69c36f");
		dao.update(aux);
		dao.commit();
		dao.close();

		resultado = "Feriado Substituto Cadastrado Com Sucesso!";
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("cadastrar-feriado-substituto.jsp").forward(request, response);
	}
	protected void alteraFeriadoJSP(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");

		FeriadoDAO dao = new FeriadoDAO();
		dao.open();
		dao.begin();
		Feriado aux = dao.read(id);
		dao.close();

		request.setAttribute("feriado", aux);
		request.getRequestDispatcher("alterar-feriado.jsp").forward(request, response);
	}
	
	protected void alteraFeriado(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String resultado;
		String id = request.getParameter("alteraIdFeriado");
		String titulo = request.getParameter("AlteraTituloFeriado");
		String inicio = request.getParameter("AlteraInicioFeriado");
		String fim = request.getParameter("AlteraFimFeriado");
		FeriadoDAO dao = new FeriadoDAO();
		dao.open();
		dao.begin();
		Feriado aux = dao.read(id);
		aux.setTitulo(titulo);
		aux.setInicio(inicio);
		aux.setFim(fim);
		dao.update(aux);
		dao.commit();
		dao.close();

		resultado = "Feriado Alterado Com Sucesso!";
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("alterar-feriado.jsp").forward(request, response);
	}
	
	protected void excluirFeriado(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String resultado;
		String id = request.getParameter("alteraIdFeriado");
		FeriadoDAO dao = new FeriadoDAO();
		dao.open();
		dao.begin();
		Feriado aux = dao.read(id);
		dao.delete(aux);
		dao.commit();
		dao.close();

		resultado = "Feriado excluido Com Sucesso!";
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("alterar-feriado.jsp").forward(request, response);
	}

	protected void adicionarNota(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String resultado;
		String descricao = request.getParameter("descricaoNota");
		String dt = request.getParameter("dataNota");
		System.out.println(request.getParameter("dataNota"));
		
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		UsuarioDAO dao = new UsuarioDAO();
		dao.open();
		dao.begin();
		Usuario aux = dao.read(u.getId());
		aux.addNota(descricao, dt);
		dao.update(aux);
		dao.commit();
		dao.refresh(aux);
		dao.close();
		session.setAttribute("usuario", aux);
		resultado = "Nota Cadastrada Com Sucesso!";
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("adicionar-nota.jsp").forward(request, response);
	}
	
	protected void adicionarNotaJSP(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String data = request.getParameter("data");

		
		request.setAttribute("dt", data);
		request.getRequestDispatcher("adicionar-nota.jsp").forward(request, response);
	}
	

	protected void getNotas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Nota> notas = null;
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		notas = u.getNotas();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(new Gson().toJson(notas));
		
	}
	
	protected void getCalendarioUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Nota> notas = null;
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		notas = u.getNotas();
		
			System.out.println(notas.get(0).getId());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(new Gson().toJson(notas));
		
	}
	
	
	protected void alterarNotaJSP(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("descricao", request.getParameter("descricao"));
		request.setAttribute("data", request.getParameter("data"));
		
		request.getRequestDispatcher("alterar-nota.jsp").forward(request, response);
	}
	
	protected void alterarNota(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String resultado = null;
		List<Nota> notas = null;
		String data = request.getParameter("alterarDataNota");
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); 
		Date d = sdf1.parse(data);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		notas = u.getNotas();
		int id = Integer.parseInt(request.getParameter("id"));
		String descricao = request.getParameter("alterarDescricaoNota");
	
		
		ListIterator<Nota> it = notas.listIterator();
		while(it.hasNext()){
			Nota n = (Nota) it.next();
			if(n.getId() == id){
				notas.remove(n);
				UsuarioDAO dao = new UsuarioDAO();
				dao.open();
				dao.begin();
				n.setText(descricao);
				n.setDate(sdf2.format(d));
				notas.add(n);
				u.setNotas(notas);
				dao.update(u);
				dao.commit();
				dao.refresh(u);
				dao.close();
				resultado = "Nota alterada Com Sucesso!";
				session.setAttribute("usuario", u);
			}
			
			
			
		}
		
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("alterar-nota.jsp").forward(request, response);
		
	}
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	
	protected void alterarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		request.setAttribute("usuario", u);
		request.getRequestDispatcher("alterar-usuario.jsp").forward(request, response);
	}
	

	protected void alterar_Usuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("password");
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		u.setNome(nome);
		u.setLogin(login);
		u.setSenha(senha);
		UsuarioDAO dao = new UsuarioDAO();
		dao.open();
		dao.begin();
		dao.update(u);
		dao.commit();
		dao.refresh(u);
		dao.close();
		String resultado = "Usuário alterado Com Sucesso!";
		request.setAttribute("resultado", resultado);
		RequestDispatcher d = request.getRequestDispatcher("cadastro.jsp");
		d.forward(request, response);

	}

	protected void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Usuario> usuarios = null;
		UsuarioDAO dao = new UsuarioDAO();
		dao.open();
		dao.begin();
		usuarios = dao.readAll();
		dao.commit();
		dao.close();
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher d = request.getRequestDispatcher("lista-usuarios.jsp");
		d.forward(request, response);

	}
	
	protected void excluirNota(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String resultado;
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		int id = Integer.parseInt(request.getParameter("id"));
		UsuarioDAO dao = new UsuarioDAO();
		NotaDAO daoNota = new NotaDAO();
		u.removerNota(id);
		dao.open();
		dao.begin();
		dao.update(u);
		dao.commit();
		dao.refresh(u);
		dao.close();
		daoNota.open();
		daoNota.begin();
		Nota n = daoNota.read(id);
		daoNota.delete(n);
		daoNota.commit();
		daoNota.close();
		session.setAttribute("usuario", u);
		resultado = "Nota Excluida Com Sucesso!";
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("alterar-nota.jsp").forward(request, response);
	}
	
	protected void excluirUsuario(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String resultado;
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		UsuarioDAO dao = new UsuarioDAO();
		dao.open();
		dao.begin();
		dao.delete(u);
		dao.commit();
		dao.close();
		resultado = "Usuário Excluído com Sucesso!";
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("controller.do?op=logout").forward(request, response);
	}
	
	protected void excluirUsuarioAdm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String resultado;
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.open();
		dao.begin();
		Usuario u = dao.read(request.getParameter("id"));
		dao.delete(u);
		dao.commit();
		dao.close();
		resultado = "Usuário Excluído com Sucesso!";
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("controller.do?op=listarUsuarios").forward(request, response);
	}
}
