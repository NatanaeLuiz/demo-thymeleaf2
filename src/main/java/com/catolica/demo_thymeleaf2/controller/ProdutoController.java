package com.catolica.demo_thymeleaf2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catolica.demo_thymeleaf2.model.Produto;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    List<Produto> produtos = new ArrayList<Produto>();

    public ProdutoController() {
        Produto p1 = new Produto(1, "descricaoP1", new Date(), "123456789", true);
        Produto p2 = new Produto(2, "descricaoP2", new Date(), "987654321", true);

        produtos.add(p1);
        produtos.add(p2);
    }

    @GetMapping
    public String listar(Model model){
        
        model.addAttribute("produtos", produtos);
        return "produtos/listar";
    }
}
