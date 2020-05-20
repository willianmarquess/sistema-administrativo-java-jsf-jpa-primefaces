/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.EstoqueDAO;
import br.com.adm.dao.ProdutoDAO;
import br.com.adm.model.Estoque;
import br.com.adm.model.Produto;
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
@ManagedBean(name = "AlterarEstoqueBean")
@ViewScoped
public class AlterarEstoqueBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Produto produto =  new Produto();
    private Estoque estoque = new Estoque();
    private FacesContext context;
    
    
    
    public void restaurar(){
        try {
            EstoqueDAO dao = new EstoqueDAO();
            ProdutoDAO daoProduto = new ProdutoDAO();
            estoque = dao.restaurar(estoque.getIdEstoque());
            produto = daoProduto.restaurar(estoque.getProdutoEstoque().getIdProduto());
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar os itens do estoque! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void alterar(){
        context = FacesContext.getCurrentInstance();
        try {
            EstoqueDAO dao = new EstoqueDAO();
            estoque.setProdutoEstoque(produto);
            if (dao.alterar(estoque)) {
                context.addMessage(null, new FacesMessage("Estoque alterado com sucesso!"));
            }else{
            FacesMessage mensagem = new FacesMessage("Erro ao alterar o estoque!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao alterar os dados do Estoque! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void produtoSelecionado(SelectEvent event){
      produto = (Produto) event.getObject();
      estoque.setProdutoEstoque(produto);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }
    
    
}
