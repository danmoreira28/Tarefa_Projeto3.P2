package br.com.danilo.services;

/**
 * @author danmoreira28
 */

import br.com.danilo.dao.IProdutoDAO;
import br.com.danilo.domain.Produto;
import br.com.danilo.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
