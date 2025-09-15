package br.com.fiap.fiapstore.dao;

import br.com.fiap.fiapstore.exception.DBException;
import br.com.fiap.fiapstore.model.Produto;

import java.util.List;

public interface ProdutoDAO {
    void cadastrar(Produto produto) throws DBException;
    void atualizar(Produto produto) throws DBException;
    void remover(int codigo) throws DBException;
    void buscar(int id);
    List<Produto> listar();
}
