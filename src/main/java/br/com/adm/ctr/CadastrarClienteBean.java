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
@ManagedBean(name = "CadastrarClienteBean")
@ViewScoped
public class CadastrarClienteBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade;
    private PessoaFisica cliente = new PessoaFisica();
    private String nomeCidade;
    private FacesContext context;
    
    public void cidadeSelecionada(SelectEvent event)
    {
        cidade = (Cidade) event.getObject();
    }
    
    public void salvar()
    {
        context = FacesContext.getCurrentInstance();
        try {
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            cliente.setStatusPessoa(Boolean.TRUE);
            cliente.setTipoPessoaFisica("cliente");
            cliente.setCidadePessoa(cidade);
            if (dao.salvar(cliente)) {
                context.addMessage(null, new FacesMessage("Cliente salvo com sucesso!"));
                cliente = new PessoaFisica();
                cidade = new Cidade();
                nomeCidade = "";
            }else{
                FacesMessage mensagem = new FacesMessage("Erro ao salvar Cliente! ");
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar o Cliente! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public PessoaFisica getCliente() {
        return cliente;
    }

    public void setCliente(PessoaFisica cliente) {
        this.cliente = cliente;
    }

    @NotBlank
    public String getNomeCidade() {
        return cidade  == null ? null : cidade.getNomeCidade();
    }

    public void setNomeCidade(String nomeCidade) {
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }
    
    
}
