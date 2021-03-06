/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.PessoaFisicaDAO;
import br.com.adm.model.Cidade;
import br.com.adm.model.PessoaFisica;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "AlterarPessoaFisicaBean")
@ViewScoped
public class AlterarPessoaFisicaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private PessoaFisica pessoa = new PessoaFisica();
    private Cidade cidade;
    private String nomeCidade;
    
    public void restaurar(){
        try {
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            pessoa = dao.restaurar(pessoa.getIdPessoa());
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar pessoa! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void cidadeSelecionada(SelectEvent event){
    cidade = (Cidade) event.getObject();
    }
    
    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @NotBlank
    public String getNomeCidade() {
        return cidade  == null ? null : cidade.getNomeCidade();
    }

    public void setNomeCidade(String nomeCidade) {
    }
    
    
    
}
