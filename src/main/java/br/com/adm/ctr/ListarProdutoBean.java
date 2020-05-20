/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.ProdutoDAO;
import br.com.adm.model.Produto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "ListarProdutoBean")
@ViewScoped
public class ListarProdutoBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private List<Produto> produtos;
    private Boolean status = true;
    private String parametro = "todas";
    private String campo;

    public void listar(){
        try {
            ProdutoDAO dao = new ProdutoDAO();
            produtos = dao.listar(parametro, campo, status);
        } catch (Exception e) {
            System.out.println("Problemas ao listar Produtos! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo.toUpperCase();
    }
    
    
    
}
