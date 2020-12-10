/**
 * 
 */
package br.com.acme.agenda.service;

import java.util.List;

import br.com.acme.agenda.model.Contato;

/**
 * @author wagner
 *
 */
public interface ContatoService {

	public void salvar(Contato contato);

	public List<Contato> listarContatos();

	public void remover(Long idContato);

	public Contato buscarPorIdContato(Long idContato);
}
