package com.example.demo.repository;

import java.util.HashMap;

import com.example.demo.model.Produto;

import org.springframework.stereotype.Repository;

/**
 * ProdutosCadastrados
 */
@Repository
public class ProdutosRepository {

    private HashMap<Integer,Produto> p = new HashMap<Integer,Produto>();

    public ProdutosRepository()
    {
        p.put(0,new Produto(0,"prod a",10,100));
        p.put(1,new Produto(1,"prod b",20,90));
        p.put(2,new Produto(2,"prod c",30,80));
        p.put(3,new Produto(3,"prod d",40,70));
        p.put(4,new Produto(4,"prod e",50,60));
        p.put(5,new Produto(5,"prod f",60,50));
        p.put(6,new Produto(6,"prod g",70,40));
        p.put(7,new Produto(7,"prod h",80,30));
        p.put(8,new Produto(8,"prod i",90,20));
        p.put(9,new Produto(9,"prod j",100,0));
    }
    public Produto getProdutobyid (int id) {
        return p.get(id);
    }
    public HashMap<Integer,Produto> getProdutos(){
        return p;
    }
    public int getSize(){
        return p.size();
    }

}