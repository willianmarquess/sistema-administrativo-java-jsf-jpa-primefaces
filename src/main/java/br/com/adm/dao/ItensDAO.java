/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.dao;

import br.com.adm.model.Item;
import br.com.adm.util.Connection;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jason
 */
public class ItensDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    public ItensDAO() {
        try {
            manager = Connection.getEntityManager();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Problemas ao conectar com o banco de dados! Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean salvar(Item model) {
        EntityTransaction trx = manager.getTransaction();
        try {
            trx.begin();
            manager.persist(model);
            trx.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar item ! Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o banco de dados!"+e.getMessage());
                e.printStackTrace(); 
            }
        }
    }
}
