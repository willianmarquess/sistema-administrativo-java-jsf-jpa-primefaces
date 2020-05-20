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
@ManagedBean(name = "CadastrarFuncionarioBean")
@ViewScoped
public class CadastrarFuncionarioBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private Cidade cidade;
    private String nomeCidade;
    private PessoaFisica funcionario = new PessoaFisica();
    private FacesContext context;
    
    public void cidadeSelecionada(SelectEvent event){
    cidade = (Cidade) event.getObject();
    }
    
    public void salvar(){
        context = FacesContext.getCurrentInstance();
        try {
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            funcionario.setStatusPessoa(Boolean.TRUE);
            funcionario.setCidadePessoa(cidade);
            funcionario.setTipoPessoaFisica("funcionario");
            if (dao.salvar(funcionario)) {
                context.addMessage(null, new FacesMessage("Funcionário salvo com sucesso !"));
                funcionario = new PessoaFisica();
                cidade = new Cidade();
                nomeCidade = "";
            }
            else{
            FacesMessage mensagem = new FacesMessage("Erro ao salvar funcionário!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar Funcionário ! Erro: "+e.getMessage());
            e.printStackTrace();
            
        }
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

    public PessoaFisica getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(PessoaFisica funcionario) {
        this.funcionario = funcionario;
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }
    
    
    
}
