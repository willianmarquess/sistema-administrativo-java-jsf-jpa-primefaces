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
@ManagedBean(name = "AlterarProdutoBean")
@ViewScoped
public class AlterarProdutoBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Produto produto = new Produto();
    private FacesContext context;
    private String preco;
    
    public void restaurar(){
        try {
            ProdutoDAO dao = new ProdutoDAO();
            produto = dao.restaurar(produto.getIdProduto());
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar Produto! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void alterar(){
        context = FacesContext.getCurrentInstance();
        try {
            ProdutoDAO dao = new ProdutoDAO();
            if (dao.alterar(produto)) {
                context.addMessage(null, new FacesMessage("Produto alterado com sucesso!"));
            }else{
            FacesMessage mensagem = new FacesMessage("Erro ao alterar o Produto!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao alterar o Produto! Erro: "+e.getMessage());
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

    public String getPreco() {
        return preco = String.valueOf(produto.getPrecoProduto()).replace(".", ",")+"0";
    }

    public void setPreco(String preco) {
       produto.setPrecoProduto(new Double(preco.replace(",","."))); 
    }
    
    
}
