/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.EstoqueDAO;
import br.com.adm.model.Estoque;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "ListarEstoqueBean")
public class ListarEstoqueBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String parametro = "todas";
    private String campo;
    private Boolean status = true;
    private List<Estoque> estoques;
    
    public void listar(){
        try {
            EstoqueDAO dao = new EstoqueDAO();
            estoques = dao.listar(parametro, campo, status);
        } catch (Exception e) {
            System.out.println("Problemas ao listar os produtos do estoque! Erro: "+e.getMessage());
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Estoque> getEstoques() {
        return estoques;
    }

    public void setEstoques(List<Estoque> estoques) {
        this.estoques = estoques;
    }
    
    
}
