package br.com.acme.agenda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.service.ContatoService;
import br.com.acme.agenda.service.ContatoServiceImpl;

@WebServlet("/SalvarContatoControllerServlet")
public class SalvarCadastroContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Contato contato;
	private ContatoService service;

	public SalvarCadastroContatoServlet() {
		this.contato = new Contato();
		this.service = new ContatoServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.contato.setNome(request.getParameter("nome"));
		this.contato.setEmail(request.getParameter("email"));
		this.contato.setTelefone(request.getParameter("telefone"));
		this.contato.setAtivo(true);
		this.service.salvar(this.contato);
		// response.getWriter().append("salvo com sucesso!");
		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY>");
		out.println("<H1>" + "salvo com sucesso!" + "</H1>");
		out.println("<HTML><BODY>");
		out.flush();
		out.close();
	}

}
