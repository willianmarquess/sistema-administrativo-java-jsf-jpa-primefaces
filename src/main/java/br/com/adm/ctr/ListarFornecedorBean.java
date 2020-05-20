/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.PessoaJuridicaDAO;
import br.com.adm.model.PessoaJuridica;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "ListarFornecedorBean")
@ViewScoped
public class ListarFornecedorBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String parametro = "todas";
    private String campo;
    private List<PessoaJuridica> fornecedores;
    private Boolean tipo = true;
    
    public void listar(){
        try {
            PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
            fornecedores = dao.listar(parametro, campo, "fornecedor", tipo);
        } catch (Exception e) {
            System.out.println("Problemas ao listar o fornecedor! Erro: "+e.getMessage());
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

    public List<PessoaJuridica> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<PessoaJuridica> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }
    
    
    
}
