/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.PessoaFisicaDAO;
import br.com.adm.model.PessoaFisica;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "ListarClienteBean")
@ViewScoped
public class ListarClienteBean implements Serializable{
    public static final long serialVersionUID = 1L;
    
    private String parametro = "todas";
    private String campo;
    private List<PessoaFisica> clientes;
    private Boolean status = true;
    
    public void listar(){
        try {
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            clientes = dao.listar(parametro, campo, "cliente", status);
        } catch (Exception e) {
            System.out.println("Problemas ao listar Clientes! Erro: "+e.getMessage());
            e.printStackTrace();
        }
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

    public List<PessoaFisica> getClientes() {
        return clientes;
    }

    public void setClientes(List<PessoaFisica> clientes) {
        this.clientes = clientes;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
}
