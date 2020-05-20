/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.PessoaFisicaDAO;
import br.com.adm.model.Cidade;
import br.com.adm.model.PessoaFisica;
import com.sun.javafx.logging.PulseLogger;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Jason
 */ 
@ManagedBean(name = "CadastrarPessoaFisicaBean")
@ViewScoped
public class CadastraPessoaFisicaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade;
    private String nomeCidade;
    private PessoaFisica pessoaFisica = new PessoaFisica();
    private String tipoPessoa = "cliente";
    private FacesContext context;

    public void cidadeSelecionada(SelectEvent event){
    cidade = (Cidade) event.getObject();
    }
    
    public void salvar(){
    context = FacesContext.getCurrentInstance();
        try {
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            pessoaFisica.setStatusPessoa(Boolean.TRUE);
            pessoaFisica.setTipoPessoaFisica(tipoPessoa);
            pessoaFisica.setCidadePessoa(cidade);
            if (dao.salvar(pessoaFisica)) {
                context.addMessage(null, new FacesMessage(tipoPessoa.toUpperCase()+" salvo com sucesso !"));
                this.pessoaFisica = new PessoaFisica();
                this.cidade = new Cidade();
                this.nomeCidade = "";
            }
            else{
                FacesMessage mensagem = new FacesMessage("Erro ao salvar "+tipoPessoa.toUpperCase());
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar pessoa fisica ! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    @NotBlank
    public String getNomeCidade() {
        return cidade  == null ? null : cidade.getNomeCidade();
    }

    public void setNomeCidade(String nomeCidade) {
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }


    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
    
    
    
    

   
}
