package com.catolica.demo_thymeleaf2.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Produto {

    private int codigo;

    private String descricao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date validade;

    private String ean;

    private boolean ativo;

    public Produto() {
    }

    public Produto(int codigo, String descricao, Date validade, String ean, boolean ativo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.validade = validade;
        this.ean = ean;
        this.ativo = ativo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
}