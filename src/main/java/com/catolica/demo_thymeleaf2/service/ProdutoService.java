package com.catolica.demo_thymeleaf2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.catolica.demo_thymeleaf2.model.Produto;
import com.catolica.demo_thymeleaf2.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.listarTodos();
    }

    public Produto buscarPorCodigo(int codigo) {
        return repository.buscarPorCodigo(codigo);
    }

    public void salvar(Produto produto) {
        if (produto.getCodigo() == 0)
            repository.salvar(produto);
        else
            repository.atualizar(produto);
    }

    public void excluir(int codigo) {
        repository.deletar(codigo);
    }
}