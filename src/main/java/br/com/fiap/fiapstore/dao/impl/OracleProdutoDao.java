package br.com.fiap.fiapstore.dao.impl;

import br.com.fiap.fiapstore.dao.ConnectionManager;
import br.com.fiap.fiapstore.dao.ProdutoDAO;
import br.com.fiap.fiapstore.exception.DBException;
import br.com.fiap.fiapstore.model.Produto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleProdutoDao implements ProdutoDAO {

    private Connection conexao;

    @Override
    public void cadastrar(Produto produto) throws DBException {

        PreparedStatement stmt = null;

        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "INSERT INTO TB_PRODUTO " +
        "(COD_PRODUTO, NOME_PRODUTO, QTDE_PRODUTO, " +
            "VALOR_PRODUTO, DATA_FABRICACAO) " +
            "VALUES (SQ_TB_PRODUTO.NEXTVAL, ?, ?, ?, ?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getValor());
            stmt.setDate(4, Date.valueOf(produto.getDataFabricacao()));
            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(Produto produto) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE TB_PRODUTO SET " +
                    "NOME_PRODUTO = ?, " +
                    "QTDE_PRODUTO = ?, " +
                    "VALOR_PRODUTO = ?, " +
                    "DATA_FABRICACAO = ? " +
                    "WHERE COD_PRODUTO = ? ";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getValor());
            stmt.setDate(4, Date.valueOf(produto.getDataFabricacao()));
            stmt.setInt(5, produto.getCodigo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remover(int codigo) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM TB_PRODUTO WHERE COD_PRODUTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void buscar(int codigo) {
        Produto produto = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_PRODUTO WHERE COD_PRODUTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()){
                int codigoRetornado = rs.getInt("COD_PRODUTO");
                String nome = rs.getString("NOME_PRODUTO");
                int qtd = rs.getInt("QTDE_PRODUTO");
                double valor = rs.getDouble("VALOR_PRODUTO");
                LocalDate data = rs.getDate("DATA_FABRICACAO").toLocalDate();

                produto = new Produto(codigo, nome, valor, qtd, data);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Produto> listar() {

        List<Produto> lista = new ArrayList<Produto>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_PRODUTO";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("COD_PRODUTO");
                String nome = rs.getString("NOME_PRODUTO");
                int qtd = rs.getInt("QTDE_PRODUTO");
                double valor = rs.getDouble("VALOR_PRODUTO");
                java.sql.Date data = rs.getDate("DATA_FABRICACAO");
                LocalDate dataFabricacao = rs.getDate("DATA_FABRICACAO").toLocalDate();

                Produto produto = new Produto(codigo, nome, valor, qtd, dataFabricacao);
                lista.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}
