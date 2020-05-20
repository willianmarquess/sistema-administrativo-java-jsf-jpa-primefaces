/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jason
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem;
    
    @Column(precision = 10, scale = 2)
    private Double quantidadeItem;
    
    @Column(precision = 10, scale = 2)
    private Double totalParcialItem;
    
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idproduto")
    private Produto produtoItem;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idvenda")
    private Venda vendaItem;

    public Item() {
    }
    
    

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public Double getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(Double quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public Produto getProdutoItem() {
        return produtoItem;
    }

    public void setProdutoItem(Produto produtoItem) {
        this.produtoItem = produtoItem;
    }

    public Venda getVendaItem() {
        return vendaItem;
    }

    public void setVendaItem(Venda vendaItem) {
        this.vendaItem = vendaItem;
    }

    public Double getTotalParcialItem() {
        return totalParcialItem;
    }

    public void setTotalParcialItem(Double totalParcialItem) {
        this.totalParcialItem = totalParcialItem;
    }
    
    
    
}
