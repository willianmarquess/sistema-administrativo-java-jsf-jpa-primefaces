/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jason
 */
@Entity
@PrimaryKeyJoinColumn(name = "idpessoa")
public class PessoaJuridica extends Pessoa{
    
    @Column(length = 100)
    private String razaoPessoaJuridica;
    
    @Column(length = 100)
    private String cnpjPessoaJuridica;
    
    @NotBlank
    @Column(length = 50, nullable = false)
    private String tipoPessoaJuridica;

    public PessoaJuridica(String razaoPessoaJuridica, String cnpjPessoaJuridica, String tipoPessoaJuridica, int idPessoa, String cepPessoa, String enderecoPessoa, Boolean statusPessoa, Cidade cidadePessoa, String telefonePessoa, String celularPessoa) {
        super(idPessoa, cepPessoa, enderecoPessoa, statusPessoa, cidadePessoa, telefonePessoa, celularPessoa);
        this.razaoPessoaJuridica = razaoPessoaJuridica;
        this.cnpjPessoaJuridica = cnpjPessoaJuridica;
        this.tipoPessoaJuridica = tipoPessoaJuridica;
    }
    
    public PessoaJuridica(){}

    public String getRazaoPessoaJuridica() {
        return razaoPessoaJuridica;
    }

    public void setRazaoPessoaJuridica(String razaoPessoaJuridica) {
        this.razaoPessoaJuridica = razaoPessoaJuridica;
    }

    public String getCnpjPessoaJuridica() {
        return cnpjPessoaJuridica;
    }

    public void setCnpjPessoaJuridica(String cnpjPessoaJuridica) {
        this.cnpjPessoaJuridica = cnpjPessoaJuridica;
    }

    public String getTipoPessoaJuridica() {
        return tipoPessoaJuridica;
    }

    public void setTipoPessoaJuridica(String tipoPessoaJuridica) {
        this.tipoPessoaJuridica = tipoPessoaJuridica;
    }
    
    
    
    
    
}
