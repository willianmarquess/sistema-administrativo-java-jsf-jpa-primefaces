/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.dao;

import br.com.adm.model.Cidade;
import br.com.adm.util.Connection;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jason
 */
public class CidadeDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    private EntityManager manager;

    public CidadeDAO() {
        try {
            this.manager = Connection.getEntityManager();
        } catch (Exception e) {
            System.out.println("Problemas ao se conectar com o banco de dados ! Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public List<Cidade> porNomeCidade(String nome)
    {
        List<Cidade> cidades = null;
        try {
            cidades = this.manager.createQuery("from Cidade where nomecidade like :nome", Cidade.class)
                    .setParameter("nome", "%"+nome+"%").getResultList(); 
            return cidades;
        } catch (Exception e) {
            System.out.println("Problemas ao pesquisar as cidades por nome! Erro: "+e.getMessage());
            e.printStackTrace();
          
        }finally{
            try {
                this.manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o banco de dados! Erro:  "+e.getMessage());
                e.printStackTrace();
            }
        }
          return cidades;
    }
    public Cidade restaurar(int id) {
        Cidade cidade = null;
        try {
            return cidade = manager.find(Cidade.class, id);
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar cidade! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o banco de dados! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return cidade;
    }

}
