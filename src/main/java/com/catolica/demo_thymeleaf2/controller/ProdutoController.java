package com.catolica.demo_thymeleaf2.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catolica.demo_thymeleaf2.model.Produto;
import com.catolica.demo_thymeleaf2.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    // List<Produto> produtos = new ArrayList<Produto>();

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model){

        List<Produto> produtos = service.listarTodos();
        
        model.addAttribute("produtos", produtos);
        return "produtos/listar";
    }

    @GetMapping("/novo")
    public String novoProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto,
                        @RequestParam("validade") @DateTimeFormat(pattern = "yyyy-MM-dd") Date validade) {
        service.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable int codigo, Model model) {
        Produto produto = service.buscarPorCodigo(codigo);
        model.addAttribute("produto", produto);
        return "produtos/form";
    }

    @GetMapping("/excluir/{codigo}")
    public String excluir(@PathVariable int codigo) {
        service.excluir(codigo);
        return "redirect:/produtos";
    }
}
