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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jason
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPessoa;
    
    @NotBlank
    @Column(length = 50, nullable = false)
    private String cepPessoa;
    
    @NotBlank
    @Column(length = 100, nullable = false)
    private String enderecoPessoa;
    
    @NotNull
    @Column
    private Boolean statusPessoa;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idcidade")
    private Cidade cidadePessoa;
    
    @Column(length = 30)
    private String telefonePessoa;
    
    @Column(length = 30)
    private String celularPessoa;

    public Pessoa(int idPessoa, String cepPessoa, String enderecoPessoa, Boolean statusPessoa, Cidade cidadePessoa, String telefonePessoa, String celularPessoa) {
        this.idPessoa = idPessoa;
        this.cepPessoa = cepPessoa;
        this.enderecoPessoa = enderecoPessoa;
        this.statusPessoa = statusPessoa;
        this.cidadePessoa = cidadePessoa;
        this.telefonePessoa = telefonePessoa;
        this.celularPessoa = celularPessoa;
    }
    
    public Pessoa(){}

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getCepPessoa() {
        return cepPessoa;
    }

    public void setCepPessoa(String cepPessoa) {
        this.cepPessoa = cepPessoa;
    }

    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public Boolean getStatusPessoa() {
        return statusPessoa;
    }

    public void setStatusPessoa(Boolean statusPessoa) {
        this.statusPessoa = statusPessoa;
    }

    public Cidade getCidadePessoa() {
        return cidadePessoa;
    }

    public void setCidadePessoa(Cidade cidadePessoa) {
        this.cidadePessoa = cidadePessoa;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public String getCelularPessoa() {
        return celularPessoa;
    }

    public void setCelularPessoa(String celularPessoa) {
        this.celularPessoa = celularPessoa;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idPessoa;
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
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa) {
            return false;
        }
        return true;
    }
    
    
            
}
