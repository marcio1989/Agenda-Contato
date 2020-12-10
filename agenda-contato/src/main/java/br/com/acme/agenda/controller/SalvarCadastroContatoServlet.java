package br.com.acme.agenda.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.service.ContatoService;
import br.com.acme.agenda.service.ContatoServiceImpl;

/**
 * Servlet implementation class SalvarCadastroContatoServlet
 */
@WebServlet("/SalvarContatoControllerServlet")
public class SalvarCadastroContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Contato contato;
	private ContatoService service;
	
	
    public SalvarCadastroContatoServlet() {
    	this.contato = new Contato();
		this.service = new ContatoServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.contato.setNome(request.getParameter("nome"));
		this.contato.setEmail(request.getParameter("email"));
		this.contato.setTelefone(request.getParameter("telefone"));
		this.contato.setAtivo(true);
		this.service.salvar(this.contato);
		response.getWriter().append("salvo com sucesso!");
	}

}
