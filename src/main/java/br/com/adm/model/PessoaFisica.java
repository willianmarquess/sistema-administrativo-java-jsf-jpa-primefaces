/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jason
 */
@Entity
@PrimaryKeyJoinColumn(name = "idpessoa")
public class PessoaFisica extends Pessoa {
    
    @NotBlank
    @Column(length = 100, nullable = false)
    private String nomePessoaFisica;
    
    @NotBlank
    @Column(length = 20, nullable = false)
    private String rgPessoaFisica;
    
    @NotBlank
    @Column(length = 20, nullable = false)
    private String cpfPessoaFisica;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nasc_pessoa")
    private Date dataNascPessoaFisica;
    
    @NotBlank
    @Column(length = 20, nullable = false)
    private String sexoPessoaFisica;
    
    @NotBlank
    @Column(length = 20, nullable = false)
    private String tipoPessoaFisica;
    
    @Column(precision = 10, scale = 2)
    private Double salarioPessoaFisica;
    
    @Column(length = 20)
    private String cargoPessoaFisica;

    public PessoaFisica(String nomePessoaFisica, String rgPessoaFisica, String cpfPessoaFisica, Date dataNascPessoaFisica, String sexoPessoaFisica, String tipoPessoaFisica, Double salarioPessoaFisica, String cargoPessoaFisica) {
        this.nomePessoaFisica = nomePessoaFisica;
        this.rgPessoaFisica = rgPessoaFisica;
        this.cpfPessoaFisica = cpfPessoaFisica;
        this.dataNascPessoaFisica = dataNascPessoaFisica;
        this.sexoPessoaFisica = sexoPessoaFisica;
        this.tipoPessoaFisica = tipoPessoaFisica;
        this.salarioPessoaFisica = salarioPessoaFisica;
        this.cargoPessoaFisica = cargoPessoaFisica;
    }
    
    public PessoaFisica(){}

    public String getNomePessoaFisica() {
        return nomePessoaFisica;
    }

    public void setNomePessoaFisica(String nomePessoaFisica) {
        this.nomePessoaFisica = nomePessoaFisica;
    }

    public String getRgPessoaFisica() {
        return rgPessoaFisica;
    }

    public void setRgPessoaFisica(String rgPessoaFisica) {
        this.rgPessoaFisica = rgPessoaFisica;
    }

    public String getCpfPessoaFisica() {
        return cpfPessoaFisica;
    }

    public void setCpfPessoaFisica(String cpfPessoaFisica) {
        this.cpfPessoaFisica = cpfPessoaFisica;
    }

    public Date getDataNascPessoaFisica() {
        return dataNascPessoaFisica;
    }

    public void setDataNascPessoaFisica(Date dataNascPessoaFisica) {
        this.dataNascPessoaFisica = dataNascPessoaFisica;
    }

    public String getSexoPessoaFisica() {
        return sexoPessoaFisica;
    }

    public void setSexoPessoaFisica(String sexoPessoaFisica) {
        this.sexoPessoaFisica = sexoPessoaFisica;
    }

    public String getTipoPessoaFisica() {
        return tipoPessoaFisica;
    }

    public void setTipoPessoaFisica(String tipoPessoaFisica) {
        this.tipoPessoaFisica = tipoPessoaFisica;
    }

    public Double getSalarioPessoaFisica() {
        return salarioPessoaFisica;
    }

    public void setSalarioPessoaFisica(Double salarioPessoaFisica) {
        this.salarioPessoaFisica = salarioPessoaFisica;
    }

    public String getCargoPessoaFisica() {
        return cargoPessoaFisica;
    }

    public void setCargoPessoaFisica(String cargoPessoaFisica) {
        this.cargoPessoaFisica = cargoPessoaFisica;
    }
    
    
}
