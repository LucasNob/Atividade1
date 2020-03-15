package com.example.demo.controller;

import java.util.ArrayList;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProdutosController
 */
@Controller
@RequestMapping("/produto")
public class ProdutosController {

    @Autowired
    private ProdutoService ps;

    @GetMapping("/{numProduto}")
    public ModelAndView getProduto(@PathVariable("numProduto") int numProduto)
    {
        ModelAndView mv = new ModelAndView("produtoview");
        Produto prod = ps.getProduto(numProduto);
        mv.addObject("produto", prod);
        return mv;
    }
    @GetMapping("/emEstoque")
    public ModelAndView getProdutoEmEstoque()
    {
        ModelAndView mv = new ModelAndView("produtoEmEstoque");
        String prods = ps.getProdutosEmEstoqueStr();
        mv.addObject("produtosEmEstoque", prods);
        return mv;
    }
    @GetMapping("/acima/{valorAcima}")
    public ModelAndView getProdutoAcima(@PathVariable ("valorAcima") double valorAcima)
    {
        ModelAndView mv = new ModelAndView("valorAcima");
        String prods = ps.getProdutosByValorAcimaStr(valorAcima);
        mv.addObject("prodAcima", prods);
        return mv; 
    }
    @GetMapping("/abaixo/{valorAbaixo}")
    public ModelAndView getProdutoAbaixo(@PathVariable ("valorAbaixo") double valorAbaixo)
    {
        ModelAndView mv = new ModelAndView("valorAbaixo");
        String prods = ps.getProdutosByValorAbaixoStr(valorAbaixo);
        mv.addObject("prodAbaixo", prods);
        return mv; 
    }
    
    
}