package br.com.fiap.fiapstore.teste;

import br.com.fiap.fiapstore.dao.ProdutoDAO;
import br.com.fiap.fiapstore.exception.DBException;
import br.com.fiap.fiapstore.factory.DaoFactory;
import br.com.fiap.fiapstore.model.Produto;

import java.time.LocalDate;

public class ProdutoDAOTeste {

    public static void main(String[] args) {

        ProdutoDAO dao = DaoFactory.getProdutoDAO();

        Produto produto = new Produto(
                0,
                "Teclado ABNT2",
                28.99,
                200,
                LocalDate.of(2024,07,07)
        );

        try {
            dao.cadastrar(produto);

        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }
}
