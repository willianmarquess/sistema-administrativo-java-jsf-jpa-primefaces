/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.ProdutoDAO;
import br.com.adm.model.Produto;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "CadastrarProdutoBean")
@ViewScoped
public class CadastrarProdutoBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Produto produto = new Produto();
    private FacesContext context;
    private String preço;

    public void salvar(){
        context = FacesContext.getCurrentInstance();
        try {
            ProdutoDAO dao = new ProdutoDAO();
            produto.setStatusProduto(Boolean.TRUE);
            if (dao.salvar(produto)) {
                context.addMessage(null, new FacesMessage("Produto salvo com sucesso!"));
                produto =  new Produto();
            }else{
            FacesMessage mensagem = new FacesMessage("Erro ao salvar Produto!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar Produto! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public String getPreço() {
        return preço;
    }

    public void setPreço(String preço) {
        produto.setPrecoProduto(new Double(preço.replace(",","."))); 
    }
    
    
}
