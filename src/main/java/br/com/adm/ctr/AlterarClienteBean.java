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
import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "AlterarClienteBean")
@ViewScoped
public class AlterarClienteBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade = new Cidade();
    private PessoaFisica cliente = new PessoaFisica();
    private FacesContext context;
    
    public void restaurar(){
        try {
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            CidadeDAO daocidade = new CidadeDAO();
            cliente = dao.restaurar(cliente.getIdPessoa());
            cidade = daocidade.restaurar(cliente.getCidadePessoa().getIdCidade());
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar o Cliente ! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void alterar(){
        context = FacesContext.getCurrentInstance();
        try {
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            cliente.setCidadePessoa(cidade);
            if (dao.alterar(cliente)) {
                context.addMessage(null, new FacesMessage("Cliente alterado com sucesso !"));
                
            }else{
            FacesMessage mensagem = new FacesMessage("Erro ao alterar o Cliente");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao alterar Cliente! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void cidadeSelecionada(SelectEvent event){
    cidade = (Cidade) event.getObject();
    cliente.setCidadePessoa(cidade);
    }

    public Cidade getCidade() {
        return cidade = cliente.getCidadePessoa();
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


    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }
    
    
}
