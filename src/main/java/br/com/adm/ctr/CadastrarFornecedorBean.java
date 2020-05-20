/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.PessoaJuridicaDAO;
import br.com.adm.model.Cidade;
import br.com.adm.model.PessoaJuridica;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "CadastrarFornecedorBean")
@ViewScoped
public class CadastrarFornecedorBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nomeCidade;
    private Cidade cidade;
    private PessoaJuridica fornecedor = new PessoaJuridica();
    private FacesContext context;
    
    public void cidadeSelecionada(SelectEvent event){
    cidade = (Cidade) event.getObject();
    }
    
    public void salvar(){
        context = FacesContext.getCurrentInstance();
        try {
            PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
            fornecedor.setStatusPessoa(Boolean.TRUE);
            fornecedor.setTipoPessoaJuridica("fornecedor");
            fornecedor.setCidadePessoa(cidade);
            if (dao.salvar(fornecedor)) {
                context.addMessage(null, new FacesMessage("Fornecedor cadastrado com sucesso!"));
                fornecedor = new PessoaJuridica();
                cidade = new Cidade();
                nomeCidade = "";
            }else{
            FacesMessage mensagem = new FacesMessage("Erro ao cadastrar fornecedor!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar um Fornecedor! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }

     @NotBlank
    public String getNomeCidade() {
        return cidade  == null ? null : cidade.getNomeCidade();
    }

    public void setNomeCidade(String nomeCidade) {
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public PessoaJuridica getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(PessoaJuridica fornecedor) {
        this.fornecedor = fornecedor;
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }
    
}
