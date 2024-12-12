package br.com.danilo.dao;

/**
 * @author danmoreira28
 */

import br.com.danilo.dao.generic.IGenericDAO;
import br.com.danilo.domain.Venda;
import br.com.danilo.exceptions.DAOException;
import br.com.danilo.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
