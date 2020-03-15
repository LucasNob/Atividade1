package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProdutoService
 */
@Service
public class ProdutoService {

    @Autowired ProdutosRepository pr;

    public Produto getProduto(int id)
    {
        Produto prod = pr.getProdutobyid(id);
        
        return prod;
    }

    public ArrayList<Produto> getProdutosEmEstoque(){
        ArrayList<Produto> prod = new ArrayList<>();
        Produto aux;
        for (int i=0;i<pr.getSize();i++)
        {
            aux=pr.getProdutobyid(i);
            if(aux.getEstoque()!=0)
                prod.add(aux);
        }

        return prod;
    }
    public ArrayList<Produto> getProdutosByValorAcima(double valor){
        ArrayList<Produto> prod = new ArrayList<>();
        Produto aux;
        for (int i=0;i<pr.getSize();i++) 
        {
            aux=pr.getProdutobyid(i);
            if(aux!=null)
                if(aux.getValor()>=valor)
                    prod.add(aux);
        }   
        return prod;
    }    
    public ArrayList<Produto> getProdutosByValorAbaixo(double valor){
        ArrayList<Produto> prod = new ArrayList<>();
        Produto aux;
        for (int i=0;i<pr.getSize();i++) 
        {
            aux=pr.getProdutobyid(i);
            if(aux!=null)
                if(aux.getValor()<=valor)
                    prod.add(aux);
        }   
        return prod;
    }
    public String getProdutosEmEstoqueStr(){
        String prod="";
        Produto aux;
        for (int i=0;i<pr.getSize();i++)
        {
            aux=pr.getProdutobyid(i);
            if(aux.getEstoque()!=0)
                prod+=(aux.toString());
        }
        System.out.println(prod);
        return prod;
    }
    public String getProdutosByValorAcimaStr(double valor){
        String prod="";
        Produto aux;
        for (int i=0;i<pr.getSize();i++) 
        {
            aux=pr.getProdutobyid(i);
            if(aux!=null)
                if(aux.getValor()>=valor)
                    prod+=aux.toString();
        }   
        return prod;
    }    
    public String getProdutosByValorAbaixoStr(double valor){
        String prod="";
        Produto aux;
        for (int i=0;i<pr.getSize();i++) 
        {
            aux=pr.getProdutobyid(i);
            if(aux!=null)
                if(aux.getValor()<=valor)
                    prod+=aux.toString();
        }   
        return prod;
    }
    
    
}