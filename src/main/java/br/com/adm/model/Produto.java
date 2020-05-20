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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jason
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int idProduto;

    @NotNull
    @NotBlank
    @Column(length = 10, nullable = false)
    private String codigoProduto;
    
    
    @Column(length = 100, nullable = false)
    private String marcaProduto;

    @NotNull
    @NotBlank
    @Column(length = 100, nullable = false)
    private String nomeProduto;

    @NotNull
    @Column(precision = 10, scale = 2, nullable = false)
    private Double precoProduto;

    @NotNull
    @Column
    private Boolean statusProduto;

    public Produto(int idProduto, String codigoProduto, String marcaProduto, String nomeProduto, Double precoProduto, Boolean statusProduto) {
        this.idProduto = idProduto;
        this.codigoProduto = codigoProduto;
        this.marcaProduto = marcaProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.statusProduto = statusProduto;
    }

   

    public Produto() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Boolean getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(Boolean statusProduto) {
        this.statusProduto = statusProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idProduto;
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
        final Produto other = (Produto) obj;
        if (this.idProduto != other.idProduto) {
            return false;
        }
        return true;
    }

}
