/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.dao;

import br.com.adm.model.PessoaFisica;
import br.com.adm.util.Connection;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jason
 */
public class PessoaFisicaDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    public PessoaFisicaDAO() throws Exception {
        try {
            this.manager = Connection.getEntityManager();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception("Problemas ao conectar com o Banco de Dados! Erro: " + e.getMessage());
        }
    }

    public boolean salvar(PessoaFisica model) {
        EntityTransaction trx = manager.getTransaction();
        try {
            trx.begin();
            manager.persist(model);
            System.out.println("Pessoa fisica gravada com sucesso !");
            trx.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar pessoa fisica! Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o banco de dados ! Erro:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public List<PessoaFisica> listar(String parametro, String campo, String tipo, Boolean status) {
        List<PessoaFisica> pessoas = null;
        try {
            if (!parametro.equals("") && !campo.equals("") && !parametro.equals("todas")) {

                pessoas = this.manager.createQuery("from PessoaFisica where statuspessoa = "+status+" and "
                        + "tipopessoafisica = '"+tipo+"' and "
                        + parametro + " like :campo", PessoaFisica.class)
                        .setParameter("campo", "%" + campo + "%").getResultList();

            } else {
                pessoas = this.manager.createQuery("from PessoaFisica where statuspessoa = "+status+" and "
                        + "tipopessoafisica = '"+tipo+"' "
                        + "order by nomepessoafisica", PessoaFisica.class).getResultList();

            }
        } catch (Exception e) {
            System.out.println("Problemas ao listar pessoas! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o banco de dados! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return pessoas;
    }

    public PessoaFisica restaurar(int id) {
        PessoaFisica pessoa = null;
        try {
            return pessoa = manager.find(PessoaFisica.class, id);
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar pessoa! Erro: " + e.getMessage());
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

    public boolean alterar(PessoaFisica pessoa) {
        EntityTransaction trx = manager.getTransaction();
        try {
            trx.begin();
            manager.merge(pessoa);
            trx.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao alterar os dados da pessoa! Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexao com o banco de dados! Erro :" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
