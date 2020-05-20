/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.CidadeDAO;
import br.com.adm.dao.PessoaFisicaDAO;
import br.com.adm.model.Cidade;
import br.com.adm.model.PessoaFisica;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "AlterarFuncionarioBean")
@ViewScoped
public class AlterarFuncionarioBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade = new Cidade();
    private PessoaFisica funcionario = new PessoaFisica();
    private FacesContext context;
    
    public void restaurar(){
        try {
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            CidadeDAO daocidade = new CidadeDAO();
            funcionario = dao.restaurar(funcionario.getIdPessoa());
            cidade = daocidade.restaurar(funcionario.getCidadePessoa().getIdCidade());
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar o Funcionário! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void alterar(){
        context = FacesContext.getCurrentInstance();
        try {
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            funcionario.setCidadePessoa(cidade);
            if (dao.alterar(funcionario)) {
                context.addMessage(null, new FacesMessage("Funcionário alterado com sucesso!"));
            }else{
                FacesMessage mensagem = new FacesMessage("Funcionário alterado com sucesso!");
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao alterar o Funcionário");
        }
    }
    
    public void cidadeSelecionada(SelectEvent event)
    {
    cidade = (Cidade) event.getObject();
    funcionario.setCidadePessoa(cidade);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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
