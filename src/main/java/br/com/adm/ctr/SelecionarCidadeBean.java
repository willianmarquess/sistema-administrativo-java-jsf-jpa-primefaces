/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.CidadeDAO;
import br.com.adm.model.Cidade;
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
@ManagedBean(name = "SelecionarCidadeBean")
@ViewScoped
public class SelecionarCidadeBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private List<Cidade> cidades;
    
    public void pesquisar()
    {
        try {
            CidadeDAO dao = new CidadeDAO();
            cidades = dao.porNomeCidade(nome);
        } catch (Exception e) {
            System.out.println("Problemas ao listar as cidades ! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void abrirDialogo(){
        Map<String, Object> opcoes = new HashMap<>();
        
        opcoes.put("modal", true);
        opcoes.put("resizable", false);
        opcoes.put("contentHeight", 470);
        
        RequestContext.getCurrentInstance().openDialog("SelecionarCidade", opcoes, null);
    }
    
    public void selecionarCidade(Cidade cidade)
    {
    RequestContext.getCurrentInstance().closeDialog(cidade);
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
