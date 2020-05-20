/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.util;

import br.com.adm.model.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jason
 */
@WebFilter("*.xhtml")
public class Filtro implements Filter {

    Usuario usuario = new Usuario();

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getSession(true).getAttribute("usuariologado") != null) {
            usuario = (Usuario) request.getSession(true).getAttribute("usuariologado");
        }
        if (request.getSession(true).getAttribute("usuariologado") == null && !request.getRequestURI().endsWith("/login.xhtml") && !request.getRequestURI().contains("/javax.faces.resource/")) {
            response.sendRedirect(request.getContextPath()
                    + "/faces/login.xhtml");
        } else {
            chain.doFilter(req, res);
        }

//        if (session != null) {
//            usuario = (Usuario) session.getAttribute("usuariologado");
//        }
//        if (usuario == null) {
//            String contextPath = request.getContextPath();
//            System.out.println("AQUEEEEEEE" + contextPath);
//            response.sendRedirect(contextPath + "/faces/login.xhtml");
//        } else {
//            chain.doFilter(request, response);
//        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
