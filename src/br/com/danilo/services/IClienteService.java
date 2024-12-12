package br.com.danilo.services;

/**
 * @author danmoreira28
 */

import br.com.danilo.domain.Cliente;
import br.com.danilo.exceptions.DAOException;
import br.com.danilo.exceptions.TipoChaveNaoEncontradaException;
import br.com.danilo.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
