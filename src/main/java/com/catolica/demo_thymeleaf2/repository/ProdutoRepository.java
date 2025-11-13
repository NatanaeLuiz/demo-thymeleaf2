package com.catolica.demo_thymeleaf2.repository;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.catolica.demo_thymeleaf2.model.Produto;

@Repository
public class ProdutoRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Produto produto) {
        jdbcTemplate.update(
                "INSERT INTO produto (descricao, validade, ean, ativo, preco) VALUES (?, ?, ?, ?, ?)",
                produto.getDescricao(),
                new Date(produto.getValidade().getTime()),
                produto.getEan(),
                produto.isAtivo(),
                produto.getPreco()
        );
    }

    public List<Produto> listarTodos() {
        return jdbcTemplate.query("SELECT * FROM produto",
                (rs, rowNum) -> new Produto(
                        rs.getInt("codigo"),
                        rs.getString("descricao"),
                        rs.getDate("validade"),
                        rs.getString("ean"),
                        rs.getBoolean("ativo"),
                        rs.getDouble("preco")
                ));
    }

    public Produto buscarPorCodigo(int codigo) {
        return jdbcTemplate.queryForObject("SELECT * FROM produto WHERE codigo = ?",
                (rs, rowNum) -> new Produto(
                        rs.getInt("codigo"),
                        rs.getString("descricao"),
                        rs.getDate("validade"),
                        rs.getString("ean"),
                        rs.getBoolean("ativo"),
                        rs.getDouble("preco")
                ), codigo);
    }

    public void atualizar(Produto produto) {
        jdbcTemplate.update(
                "UPDATE produto SET descricao=?, validade=?, ean=?, ativo=?, preco=? WHERE codigo=?",
                produto.getDescricao(),
                new Date(produto.getValidade().getTime()),
                produto.getEan(),
                produto.isAtivo(),
                produto.getPreco(),
                produto.getCodigo()
        );
    }

    public void deletar(int codigo) {
        jdbcTemplate.update("DELETE FROM produto WHERE codigo = ?", codigo);
    }
}
