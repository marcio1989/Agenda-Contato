/**
 * 
 */
package br.com.acme.agenda.service;

import java.util.List;

import br.com.acme.agenda.dao.ContatoDao;
import br.com.acme.agenda.dao.ContatoDaoImpl;
import br.com.acme.agenda.model.Contato;

/**
 * @author SEUNDA CAMADA
 *
 */
public class ContatoServiceImpl implements ContatoService {

	private ContatoDao contatoDao;
	private Contato contato;

	public ContatoServiceImpl() {
		contatoDao = new ContatoDaoImpl();
	}

	@Override
	public void salvar(Contato contato) {
		this.contatoDao.salvar(contato);
	}

	@Override
	public List<Contato> listarContatos() {
		return this.contatoDao.listarContatos();
	}

	@Override
	public void remover(Long idContato) {
		this.contatoDao.remover(idContato);
	}

	@Override
	public Contato buscarPorIdContato(Long idContato) {
		return this.contatoDao.buscarPorIdContato(idContato);
	}

	@Override
	public void ativarDesativarContato(Long idContato) {
		this.contatoDao.ativarDesativarContato(idContato);

	}

	@Override
	public void editarContato(Long idContato) {
		this.contatoDao.editarContato(idContato, contato);

	}

	@Override
	public Object buscaPorEmail(String email) {
		return null;
	}


}
