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
@ManagedBean(name = "AlterarEmpresaBean")
@ViewScoped
public class AlterarEmpresaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade;
    private PessoaJuridica empresa = new PessoaJuridica();
    private FacesContext context;
    
    public void restaurar(){
        try {
            PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
            CidadeDAO daocidade = new CidadeDAO();
            empresa = dao.restaurar(empresa.getIdPessoa());
            cidade = daocidade.restaurar(empresa.getCidadePessoa().getIdCidade());
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar a Empresa! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void alterar(){
        context = FacesContext.getCurrentInstance();
        try {
            PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
            empresa.setCidadePessoa(cidade);
            if (dao.alterar(empresa)) {
                context.addMessage(null, new FacesMessage("Empresa alterada com sucesso!"));
            }else{
                FacesMessage mensagem = new FacesMessage("Erro ao alterar a Empresa");
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao alterar a Empresa! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void cidadeSelecionada(SelectEvent event){
    cidade = (Cidade) event.getObject();
    empresa.setCidadePessoa(cidade);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public void setEmpresa(PessoaJuridica empresa) {
        this.empresa = empresa;
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }
    
    
}
