package br.com.fiap.fiapstore.factory;

import br.com.fiap.fiapstore.dao.ProdutoDAO;
import br.com.fiap.fiapstore.dao.impl.OracleProdutoDao;

public class DaoFactory {

    public static ProdutoDAO getProdutoDAO() {
        return new OracleProdutoDao();
    }
}
