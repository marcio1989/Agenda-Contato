package br.com.acme.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.mapping.IdentifierCollection;

import br.com.acme.agenda.dao.ContatoDao;
import br.com.acme.agenda.dao.ContatoDaoImpl;
import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.service.ContatoService;
import br.com.acme.agenda.service.ContatoServiceImpl;
import br.com.acme.agenda.utils.Constantes;
import br.com.acme.agenda.utils.JPAUtil;

@WebServlet("/contatoControllerServlet")
public class ContatoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Contato contato;
	private ContatoService service;
	private List<Contato> contatos;

	public ContatoControllerServlet() {
		// this.setContato(new Contato());
		this.contato = new Contato();
		this.service = new ContatoServiceImpl();
		this.contatos = new ArrayList<Contato>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// switch

		String id = request.getParameter("id");
		String action = request.getParameter("action");
		String fuction = request.getParameter("fuction");
		String ativar = request.getParameter("ativar");

		if (action != request.getParameter(id)) {
			this.service.remover(Long.parseLong(id));
		}
		if (fuction != request.getParameter(id)) {
			this.service.editarContato(Long.parseLong(id));
		}
		if (ativar != request.getParameter(id)) {
			this.service.ativarDesativarContato(Long.parseLong(id));
			request.setAttribute("ativar/desativar", "Contato desativado/ativado cadastrado com sucesso");
		}
		this.contatos = this.service.listarContatos();
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.LISTAR_CONTATOS);
		request.setAttribute("contatos", this.contatos);
		rd.forward(request, response);
		
		
		/*
		 * if (action != request.getParameter(id)) { 
		 * switch(id) {
		 *  case "action":
		 * this.service.remover(Long.parseLong(id));
		 * return;
		 * case "fuction":
		 * this.service.editarContato(Long.parseLong(id)); 
		 * return; 
		 * case "ativar":
		 * this.service.ativarDesativarContato(Long.parseLong(id));
		 * return; 
		 * default:
		 * this.contatos = this.service.listarContatos(); 
		 * RequestDispatcher rd = request.getRequestDispatcher(Constantes.LISTAR_CONTATOS);
		 * request.setAttribute("contatos", this.contatos); rd.forward(request, response); 
		 * return; } }
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.contato = new Contato(); // contato instanciado
		// recupera dos dados do resquest/ formulário
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");

		// set os atributos na instancia de contato
		this.contato.setNome(nome);
		this.contato.setEmail(email);
		this.contato.setTelefone(telefone);
		this.contato.isAtivo();

		if (!validEmail(email)) {
			this.service.salvar(this.contato);
			request.setAttribute("sucesso", "Contato" + nome + " cadastrado com sucesso");
		} else {
			request.setAttribute("contatoExiste", "Contato com e-mail " + " já existe");
		}
		doGet(request, response);
	}

	private boolean validEmail(String email) {
		if (this.service.buscaPorEmail(email) != null) {
			return true;
		} else {
			return false;
		}
	}
}