/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.dao;

import br.com.adm.model.PessoaJuridica;
import br.com.adm.util.Connection;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jason
 */
public class PessoaJuridicaDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    public PessoaJuridicaDAO() throws Exception {
        try {
            manager = Connection.getEntityManager();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception("Problemas ao conectar com o Banco de Dados! Erro: " + e.getMessage());
        }
    }

    public boolean salvar(PessoaJuridica model) {
        EntityTransaction trx = manager.getTransaction();
        try {
            trx.begin();
            manager.persist(model);
            trx.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao salvar pessoa juridica! Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexao com o banco de dados! Erro: " + e.getMessage());
                e.printStackTrace();

            }
        }
    }

    public List<PessoaJuridica> listar(String parametro, String campo, String tipo, Boolean status) {
        List<PessoaJuridica> pessoas = null;
        try {
            if (!parametro.equals("") && !campo.equals("") && !parametro.equals("todas")) {           
                pessoas = this.manager.createQuery("from PessoaJuridica where statuspessoa = " + status + " and "
                        + "tipopessoajuridica = '" + tipo + "' and "
                        + parametro + " like :campo", PessoaJuridica.class)
                        .setParameter("campo", "%" + campo + "%").getResultList();              
            } else {            
                pessoas = this.manager.createQuery("from PessoaJuridica where statuspessoa = " + status + " and  tipopessoajuridica = '" + tipo + "' "
                        + "order by razaopessoajuridica", PessoaJuridica.class).getResultList();          
            }
        } catch (Exception e) {
            System.out.println("Problemas ao listar pessoa juridica! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o banco de dados! Erro :" + e.getMessage());
                e.printStackTrace();
            }
        }
        return pessoas;
    }

    public PessoaJuridica restaurar(int id) {
        PessoaJuridica pessoa = null;
        try {
            return pessoa = manager.find(PessoaJuridica.class, id);
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar pessoa juridica! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o banco de dados! Erro: " + e.getMessage());
                e.printStackTrace();

            }
        }
        return pessoa;
    }

    public boolean alterar(PessoaJuridica model) {
        EntityTransaction trx = manager.getTransaction();
        try {
            trx.begin();
            manager.merge(model);
            trx.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao alterar pessoa juridica! Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexao com o banco de dados! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
