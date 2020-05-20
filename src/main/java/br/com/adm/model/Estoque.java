/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity
public class Estoque implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstoque;
    
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "idproduto")
    private Produto produtoEstoque;
    
    @NotNull
    @Column(precision = 10, scale = 2)
    private Double quantidadeEstoque;
    
    @NotNull
    @Column(precision = 10, scale = 2)
    private Double quantidadeMinEstoque;
    
    @NotNull
    @Column
    private Boolean statusEstoque;
    
    private Double valorTotal;
    
    private Double quantidade;

    public Estoque() {
    }

    public Estoque(int idEstoque, Produto produtoEstoque, Double quantidadeEstoque, Double quantidadeMinEstoque, Boolean statusEstoque, Double valorTotal) {
        this.idEstoque = idEstoque;
        this.produtoEstoque = produtoEstoque;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinEstoque = quantidadeMinEstoque;
        this.statusEstoque = statusEstoque;
        this.valorTotal = valorTotal;
    }

    

    
    
    

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Produto getProdutoEstoque() {
        return produtoEstoque;
    }

    public void setProdutoEstoque(Produto produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Double getQuantidadeMinEstoque() {
        return quantidadeMinEstoque;
    }

    public void setQuantidadeMinEstoque(Double quantidadeMinEstoque) {
        this.quantidadeMinEstoque = quantidadeMinEstoque;
    }

    public Boolean getStatusEstoque() {
        return statusEstoque;
    }

    public void setStatusEstoque(Boolean statusEstoque) {
        this.statusEstoque = statusEstoque;
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
    
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idEstoque;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estoque other = (Estoque) obj;
        if (this.idEstoque != other.idEstoque) {
            return false;
        }
        return true;
    }
    
    
    
}
