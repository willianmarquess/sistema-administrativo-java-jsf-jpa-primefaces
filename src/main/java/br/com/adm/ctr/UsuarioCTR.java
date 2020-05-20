/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.UsuarioDAO;
import br.com.adm.model.Usuario;
import br.com.adm.util.Connection;
import br.com.adm.util.SessionContext;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "usuarioctr")
@ViewScoped
public class UsuarioCTR implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;
    private FacesContext context;
    private Usuario usuarioselecionado;

    public void carregar() throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
    }

    public void salvar() {
        context = FacesContext.getCurrentInstance();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            usuario.setStatus(Boolean.TRUE);
            if (dao.salvar(usuario)) {
                context.addMessage(null, new FacesMessage("Usuário salvo com sucesso!"));
            } else {
                FacesMessage mensagem = new FacesMessage("Erro ao cadastrar Usuário");
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar o usuário! Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void alterar() {
        context = FacesContext.getCurrentInstance();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.alterar(usuario)) {
                context.addMessage(null, new FacesMessage("Usuário alterado com sucesso !"));
            } else {
                FacesMessage mensagem = new FacesMessage("Erro ao alterar Usuário!");
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao alterar usuário! Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void excluir() {
        context = FacesContext.getCurrentInstance();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            this.restaurar();
            this.usuario = dao.restaurar(this.usuario.getIdUsuario());
            if (dao.excluir(this.usuario)) {
                context.addMessage(null, new FacesMessage(
                        "Usuário excluído com sucesso!"));
                this.listar();

            } else {
                FacesMessage mensagem = new FacesMessage("Erro ao excluir usuário");
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao excluir usuário ! Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            this.usuarios = dao.listar();
        } catch (Exception e) {
            System.out.println("Problemas ao listar usuários ! Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String logar() {
        context = FacesContext.getCurrentInstance();
        Usuario usuarioLogado = null;
        List<Usuario> lista = null;
        try {
            UsuarioDAO dao = new UsuarioDAO();
            lista = dao.logar(this.usuario.getLogin(), this.usuario.getSenha());

            if (lista.size() == 1) {
                usuarioLogado = (Usuario) lista.get(0);
                SessionContext.getInstance().setAttribute("usuariologado", usuarioLogado);
                SessionContext.getInstance().setAttribute("login", usuarioLogado.getLogin());
                SessionContext.getInstance().setAttribute("tipo", usuarioLogado.getTipo());
                return "/index.xhtml?faces-redirect=true";
            } else {
                FacesMessage mensagem = new FacesMessage("Login ou senha inválidos!");
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, mensagem);
                FacesContext.getCurrentInstance().validationFailed();
                return "";
            }
        } catch (Exception e) {
            System.out.println("Problemas ao logar usuário! Erro :" + e.getMessage());
            e.printStackTrace();
            return "";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        return "/login?faces-redirect=true";
    }

    public void restaurar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            this.usuario = dao.restaurar(this.usuario.getIdUsuario());
            System.out.println(this.usuario.getSenha());
        } catch (Exception e) {
            System.out.println("Problemas ao restaurar o usuario" + e.getMessage() + e.getClass());
            e.printStackTrace();
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioselecionado() {
        return usuarioselecionado;
    }

    public void setUsuarioselecionado(Usuario usuarioseleciondo) {
        this.usuarioselecionado = usuarioseleciondo;
    }

}
