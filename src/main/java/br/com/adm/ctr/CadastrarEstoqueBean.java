/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.EstoqueDAO;
import br.com.adm.model.Estoque;
import br.com.adm.model.PessoaFisica;
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
@ManagedBean(name = "CadastrarEstoqueBean")
@ViewScoped
public class CadastrarEstoqueBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Produto produto;
    private Estoque estoque = new Estoque();
    private String nomeProduto;
    private String nomeCliente;
    private FacesContext context;
    private PessoaFisica cliente = new PessoaFisica();
    
    public void clienteSelecionado(SelectEvent event){
        cliente = (PessoaFisica) event.getObject();
    }
    
    public void produtoSelecionado(SelectEvent event){
        produto = (Produto) event.getObject();
    }
    
    public void salvar(){
        context = FacesContext.getCurrentInstance();
        try {
            EstoqueDAO dao = new EstoqueDAO();
            estoque.setStatusEstoque(Boolean.TRUE);
            estoque.setProdutoEstoque(produto);
            if (dao.salvar(estoque)) {
            context.addMessage(null, new FacesMessage("Estoque cadastrado com sucesso!"));
            limpar();
            }else{
            FacesMessage mensagem = new FacesMessage("Erro ao cadastrar Estoque!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar Estoque! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void limpar(){
    estoque = new Estoque();
    produto = new Produto();
    nomeProduto = "";
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

    public String getNomeProduto() {
        return produto == null ? null : produto.getNomeProduto();
    }

    public void setNomeProduto(String nomeProduto) {
       
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public String getNomeCliente() {
       return cliente == null ? null : cliente.getNomePessoaFisica();
    }

    public void setNomeCliente(String nomeCliente) {
       
    }

    public PessoaFisica getCliente() {
        return cliente;
    }

    public void setCliente(PessoaFisica cliente) {
        this.cliente = cliente;
    }
    
    
    
}
