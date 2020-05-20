/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.dao;

import br.com.adm.model.Estoque;
import br.com.adm.model.Item;
import br.com.adm.model.Venda;
import br.com.adm.util.Connection;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Jason
 */
public class VendaDAO implements Serializable{
    public static final long serialVersionUID = 1L;
    
    private EntityManager manager;

    public VendaDAO() {
        try {
            manager = Connection.getEntityManager();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Problemas ao conectar com o Banco de Dados! Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public boolean salvar(Venda venda, List<Item> itens){
        EntityTransaction trx = manager.getTransaction();
        String sql = "update Estoque set quantidadeestoque = quantidadeestoque - :quantidade where idproduto = :id";
        Query query = manager.createQuery(sql);
        try {
            trx.begin();
            manager.persist(venda);
            for (Iterator<Item> iterator = itens.iterator(); iterator.hasNext();) {
                Item next = iterator.next();
                next.setVendaItem(venda);
                
                
                
                query.setParameter("quantidade", next.getQuantidadeItem());
                query.setParameter("id", next.getProdutoItem().getIdProduto());
                
                query.executeUpdate();
                
                manager.merge(next);
                manager.flush();
                manager.clear();
            }
            System.out.println("Venda cadastrada com sucesso!");
            trx.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar venda! Erro: "+e.getMessage());
            e.printStackTrace();
            trx.rollback();
            return false;
        }finally{
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o Banco de Dados");
            }
        }
    }
    
    
    
}
