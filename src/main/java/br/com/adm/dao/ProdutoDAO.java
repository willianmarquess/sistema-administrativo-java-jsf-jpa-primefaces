/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.dao;

import br.com.adm.model.Produto;
import br.com.adm.util.Connection;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jason
 */
public class ProdutoDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    public ProdutoDAO() throws Exception {
        try {
            manager = Connection.getEntityManager();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Problemas ao conectar com o Banco de Dados! Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean salvar(Produto model) {
        EntityTransaction trx = manager.getTransaction();
        try {
            trx.begin();
            manager.persist(model);
            System.out.println("Produto cadastrado com sucesso!");
            trx.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar Produto! Erro: " + e.getMessage());
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

    public List<Produto> listar(String parametro, String campo, Boolean status) {
        List<Produto> produtos = null;
        try {
            if (!parametro.equals("") && !campo.equals("") && !parametro.equals("todas")) {
                produtos = manager.createQuery("from Produto where statusproduto = " + status + " and "
                        + parametro + " like :campo", Produto.class).setParameter("campo", "%"+campo+"%").getResultList();
            } else {
                produtos = manager.createQuery("from Produto where statusproduto = " + status+
                        " order by nomeproduto", Produto.class).getResultList();
            }
            return produtos;
        } catch (Exception e) {
            System.out.println("Problemas ao listar Produto! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o Banco de Dados! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return produtos;
    }
    
    public Produto restaurar(int id)
    {
        Produto produto = null;
        try {
            return produto = manager.find(Produto.class, id);
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar Produto! Erro: "+e.getMessage());
            e.printStackTrace();
        }finally{
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com Banco de Dados! Erro: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return produto;
    }
    
    public boolean alterar(Produto produto){
        EntityTransaction trx = manager.getTransaction();
        try {
            trx.begin();
            manager.merge(produto);
            trx.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao alterar o Produto! Erro: "+e.getMessage());
            e.printStackTrace();
            return false;
        }finally{
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o Banco de Dados! Erro: "+e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
