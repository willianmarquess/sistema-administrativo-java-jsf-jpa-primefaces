/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.CidadeDAO;
import br.com.adm.dao.PessoaJuridicaDAO;
import br.com.adm.model.Cidade;
import br.com.adm.model.PessoaJuridica;
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
@ManagedBean(name = "AlterarFornecedorBean")
@ViewScoped
public class AlterarFornecedorBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade = new Cidade();
    private PessoaJuridica fornecedor = new PessoaJuridica();
    private FacesContext context;
    
    public void restaurar(){
        try {
            PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
            CidadeDAO daocidade = new CidadeDAO();
            fornecedor = dao.restaurar(fornecedor.getIdPessoa());
            cidade = daocidade.restaurar(fornecedor.getCidadePessoa().getIdCidade());
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar fornecedor! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void alterar(){
        context = FacesContext.getCurrentInstance();
        try {
            PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
            fornecedor.setCidadePessoa(cidade);
            if (dao.alterar(fornecedor)) {
                context.addMessage(null, new FacesMessage("Fornecedor alterado com sucesso!"));
            }else{
            FacesMessage mensagem = new FacesMessage("Erro ao alterar  fornecedor!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao alterar o fornecedor! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void cidadeSelecionada(SelectEvent event){
    cidade = (Cidade) event.getObject();
    fornecedor.setCidadePessoa(cidade);
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
