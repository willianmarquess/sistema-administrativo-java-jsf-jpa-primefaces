/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jason
 */
public class CarrinhoCompras implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrinho;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "idproduto")
    private Produto produtoCarrinho;

    @NotNull
    @Column(precision = 10, scale = 2)
    private Double valorTotal;

    @NotNull
    @Column(precision = 10, scale = 2)
    private Double quantidade;
    
    public CarrinhoCompras(){}

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Produto getProdutoCarrinho() {
        return produtoCarrinho;
    }

    public void setProdutoCarrinho(Produto produtoCarrinho) {
        this.produtoCarrinho = produtoCarrinho;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
    
    

}
