package br.com.danilo.dao.factory;

/**
 * @author danmoreira28
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.danilo.domain.Produto;

public class ProdutoFactory {


	public static Produto convert(ResultSet rs) throws SQLException {
		Produto prod = new Produto();
		prod.setId(rs.getLong("ID_PRODUTO"));
		prod.setCodigo(rs.getString("CODIGO"));
		prod.setNome(rs.getString("NOME"));
		prod.setDescricao(rs.getString("DESCRICAO"));
		prod.setValor(rs.getBigDecimal("VALOR"));
		prod.setCor(rs.getString("COR"));
		return prod;
	}
}