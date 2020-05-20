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
@ManagedBean(name = "ListarPessoaFisicaBean")
@ViewScoped
public class ListarPessoaFisicaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
   
    private String tipo = "cliente";
    private String parametro = "todas";
    private String campo;
    private List<PessoaFisica> pessoas;
    private Boolean status = true;

    public void listar(){
        try {
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            pessoas = dao.listar(parametro, campo, tipo, status);
        } catch (Exception e) {
            System.out.println("Problemas ao listar Pessoas! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public List<PessoaFisica> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaFisica> pessoas) {
        this.pessoas = pessoas;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
    
}
