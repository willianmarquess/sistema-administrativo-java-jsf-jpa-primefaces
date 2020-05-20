/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.util;

import javax.persistence.Persistence;

/**
 *
 * @author Jason
 */
public class CriarTabelas {

    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("AdmSystem");
    }

}
