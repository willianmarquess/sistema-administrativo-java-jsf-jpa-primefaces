/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.ProdutoDAO;
import br.com.adm.model.Produto;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "SelecionarProdutoBean")
@ViewScoped
public class SelecionarProdutoBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private List<Produto> produtos;
    private String parametro = "todas";
    private String campo;
    
    public void pesquisar(){
        try {
            ProdutoDAO dao = new ProdutoDAO();
            produtos = dao.listar(parametro, campo, true);
        } catch (Exception e) {
            System.out.println("Problemas ao listar os produtos! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void abrirDialogo(){
    Map<String, Object> opcoes =  new HashMap<>();
    
    opcoes.put("modal", true);
    opcoes.put("resizable", false);
    opcoes.put("contentHeight", 470);
    
        RequestContext.getCurrentInstance().openDialog("SelecionarProduto", opcoes, null);
    }
    
    public void selecionarProduto(Produto produto){
        RequestContext.getCurrentInstance().closeDialog(produto);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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
        this.campo = campo;
    }
    
    
}
