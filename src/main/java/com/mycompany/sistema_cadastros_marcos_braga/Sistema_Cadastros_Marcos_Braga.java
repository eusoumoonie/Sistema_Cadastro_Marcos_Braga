package com.mycompany.sistema_cadastros_marcos_braga;

import dao.CadastroDAO;              // nome correto da classe
import entity.CadastroEntity;
import java.util.List;

/**
 *
 * @author u11249767105
 */
public class Sistema_Cadastros_Marcos_Braga {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        CadastroDAO cadDao = new CadastroDAO();
        CadastroEntity cad = cadDao.buscar(1L);   // 1L porque id é Long

        if (cad != null) {
            System.out.println("Retorno: " + cad.getEmail());
        } else {
            System.out.println("Cadastro com id 1 não encontrado.");
        }

        List<CadastroEntity> lista = cadDao.listar();
        for (CadastroEntity cadastro : lista) {
            System.out.println(cadastro.getId() + " — " + cadastro.getEmail());
        }
    }
}