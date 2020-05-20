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

/**
 *
 * @author Jason
 */
@ManagedBean(name = "ListarEmpresaBean")
public class ListarEmpresaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private List<PessoaJuridica> empresas;
    private String parametro = "todas";
    private String campo;
    private Boolean tipo = true;
    
    public void listar(){
        try {
            PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
            empresas = dao.listar(parametro, campo, "empresa", tipo);
        } catch (Exception e) {
            System.out.println("Problemas ao listar Eempresas! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public List<PessoaJuridica> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<PessoaJuridica> empresas) {
        this.empresas = empresas;
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

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }
    
    
    
}
