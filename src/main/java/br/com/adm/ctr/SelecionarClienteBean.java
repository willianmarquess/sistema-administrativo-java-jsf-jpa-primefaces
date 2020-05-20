/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.PessoaFisicaDAO;
import br.com.adm.model.PessoaFisica;
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
@ManagedBean(name = "SelecionarClienteBean")
@ViewScoped
public class SelecionarClienteBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private List<PessoaFisica> clientes;
    private String parametro = "todas";
    private String campo;
    
    public void pesquisar() throws Exception{
        try {
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            clientes = dao.listar(parametro, campo, "cliente", Boolean.TRUE);
        } catch (Exception e) {
            System.out.println("Problemas ao listar Clientes! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void abrirDialogo(){
    Map<String, Object> opcoes = new HashMap<>();
    
    opcoes.put("modal", true);
    opcoes.put("resizable", false);
    opcoes.put("contentHeight", 470);
    
        RequestContext.getCurrentInstance().openDialog("SelecionarCliente", opcoes, null);
    }
    
    public void selecionarCliente(PessoaFisica cliente){
        RequestContext.getCurrentInstance().closeDialog(cliente);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PessoaFisica> getClientes() {
        return clientes;
    }

    public void setClientes(List<PessoaFisica> clientes) {
        this.clientes = clientes;
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
