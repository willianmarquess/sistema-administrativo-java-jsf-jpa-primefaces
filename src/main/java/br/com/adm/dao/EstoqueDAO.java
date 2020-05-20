/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.dao;

import br.com.adm.model.Estoque;
import br.com.adm.util.Connection;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Jason
 */
public class EstoqueDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    public EstoqueDAO() throws Exception {
        try {
            this.manager = Connection.getEntityManager();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception("Problemas ao conectar com o Banco de Dados! Erro: " + e.getMessage());
        }
    }

    public boolean salvar(Estoque model) {
        EntityTransaction trx = manager.getTransaction();
        try {
            trx.begin();
            manager.persist(model);
            System.out.println("Estoque cadastrado com sucesso!");
            trx.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar Estoque! Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o banco de Dados! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public List<Estoque> listar(String parametro, String campo, Boolean status) {
        List<Estoque> estoques = null;
        try {

            if (parametro.equals("todas")) {
                
                estoques =  manager.createQuery("from Estoque where statusestoque = " + status, Estoque.class).getResultList();
                
            } else if (parametro.equals("nomeproduto") || parametro.equals("codigoproduto")) {
            
                estoques = manager.createQuery("SELECT e FROM Estoque e INNER JOIN e.produtoEstoque p where e.statusEstoque = "+status
                        + " and "+parametro+" like  :campo", Estoque.class).setParameter("campo", "%"+campo+"%").getResultList();
                
            }
            
        } catch (Exception e) {
            System.out.println("Problemas ao listar estoque! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o Banco de Dados! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return estoques;
    }

    public Estoque restaurar(int id) {
        Estoque estoque = null;
        try {
            return estoque = manager.find(Estoque.class, id);
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar Estoque! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o Banco de Dados! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return estoque;
    }

    public boolean alterar(Estoque model) {
        EntityTransaction trx = manager.getTransaction();
        try {
            trx.begin();
            manager.merge(model);
            trx.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao alterar Estoque! Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o Banco de Dados! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
