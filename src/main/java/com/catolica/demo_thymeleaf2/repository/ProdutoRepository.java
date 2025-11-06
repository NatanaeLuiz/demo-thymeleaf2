package com.catolica.demo_thymeleaf2.repository;

import java.util.Date;

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
}
