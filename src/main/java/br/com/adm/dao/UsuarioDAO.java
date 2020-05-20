/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.dao;

import br.com.adm.model.Usuario;
import br.com.adm.util.Connection;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

/**
 *
 * @author Jason
 */
public class UsuarioDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    private EntityManager manager;

    public UsuarioDAO() throws Exception {
        try {
            this.manager = Connection.getEntityManager();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception("Problemas ao conectar com o Banco de Dados! Erro: " + e.getMessage());
        }
    }

    public boolean salvar(Usuario usuario) {
        EntityTransaction trx = this.manager.getTransaction();
        try {
            trx.begin();
            this.manager.persist(usuario);
            System.out.println("Sucesso ao gravar usuário");
            trx.commit();
            return true;
        } catch (Exception e) {
            trx.rollback();
            System.out.println("Problemas ao gravar usuário ! Erro :" + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            manager.close();
        }

    }

    public List listar() {
        List<Usuario> lista = null;
        try {
            TypedQuery<Usuario> query = this.manager.createQuery("from Usuario order by idusuario",
                    Usuario.class);
            lista = query.getResultList();
            System.out.println("TAMANHO    "+query.getResultList().size());
            return lista;
        } catch (Exception e) {
            System.out.println("Problemas ao listar o usuário ! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar o bd ! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return lista;
    }

    public List logar(String login, String senha) {
        List<Usuario> usuario = null;
        try {
            TypedQuery<Usuario> query = this.manager.createQuery("from Usuario u where u.login = :login and u.senha = :senha",
                    Usuario.class).setParameter("login", login.trim()).setParameter("senha", senha.trim());
            return usuario = query.getResultList();
        } catch (Exception e) {
            System.out.println("Problemas ao logar usuário! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                this.manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar bd ! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return usuario;
    }

    public Usuario restaurar(int id) {
        Usuario usuario = null;
        try {
            usuario = manager.find(Usuario.class, id);
            return usuario;
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar usuário ! Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }

    public boolean alterar(Usuario usuario) {
        EntityTransaction trx = this.manager.getTransaction();
        try {
            trx.begin();
            manager.merge(usuario);
            System.out.println("Usuário alterado com sucesso!");
            trx.commit();
            return true;
        } catch (Exception e) {
            trx.rollback();
            System.out.println("Problemas ao alterar usuário ! Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar BD! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }

    public boolean excluir(Usuario usuario) {
        EntityTransaction trx = this.manager.getTransaction();
        try {
            trx.begin();
            manager.remove(usuario);
            System.out.println("Usuário excluido com sucesso");
            trx.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao excluir o usuário! Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                this.manager.close();
            } catch (Exception e) {
                System.out.println("Problemas ao fechar BD! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
