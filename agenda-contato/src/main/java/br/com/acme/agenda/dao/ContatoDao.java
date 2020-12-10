/**
 * 
 */
package br.com.acme.agenda.dao;

import java.util.List;

import br.com.acme.agenda.model.Contato;

/**
 * @author david
 *
 */
public interface ContatoDao {

	public void salvar(Contato contato);
	
	public List<Contato> listarContatos();
	
	public void remover(Long idContato);
	
	public Contato buscarPorIdContato(Long idContato);
	
	public void editarContato(Long idContato, Contato contato);
}
