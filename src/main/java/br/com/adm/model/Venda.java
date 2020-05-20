/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jason
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenda;
      
    @OneToMany(mappedBy = "vendaItem", cascade = CascadeType.ALL)
    private List<Item> itens;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idcliente")
    private PessoaFisica clienteVenda;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idfuncionario")
    private PessoaFisica funcionarioVenda;
    
    @Column
    @NotBlank
    private String tipoVenda;
    
    @Column
    @NotBlank
    private String formaPagamentoVenda;
    
    @Column(length =  255)
    private String observacaoVenda;
    
    @Temporal(TemporalType.DATE)
    @Column
    private Date dataVenda;
    
    @Temporal(TemporalType.DATE)
    @Column
    private Date dataPagamentoVenda;
    
    @Column(precision = 10, scale = 2)
    private Double totalVenda;

    
    public Venda() {
    }
    
    

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public PessoaFisica getClienteVenda() {
        return clienteVenda;
    }

    public void setClienteVenda(PessoaFisica clienteVenda) {
        this.clienteVenda = clienteVenda;
    }

    public PessoaFisica getFuncionarioVenda() {
        return funcionarioVenda;
    }

    public void setFuncionarioVenda(PessoaFisica funcionarioVenda) {
        this.funcionarioVenda = funcionarioVenda;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public String getObservacaoVenda() {
        return observacaoVenda;
    }

    public void setObservacaoVenda(String observacaoVenda) {
        this.observacaoVenda = observacaoVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataPagamentoVenda() {
        return dataPagamentoVenda;
    }

    public void setDataPagamentoVenda(Date dataPagamentoVenda) {
        this.dataPagamentoVenda = dataPagamentoVenda;
    }

    public Double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public String getFormaPagamentoVenda() {
        return formaPagamentoVenda;
    }

    public void setFormaPagamentoVenda(String formaPagamentoVenda) {
        this.formaPagamentoVenda = formaPagamentoVenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idVenda;
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
        final Venda other = (Venda) obj;
        if (this.idVenda != other.idVenda) {
            return false;
        }
        return true;
    }
    
    
   
    
    
    
}
