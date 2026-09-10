/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.FornecedorEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *
 * @author u11249767105
 */
public class FornecedorDAO {

    public void salvar(FornecedorEntity fornecedor) {
        Transaction tx = null;
        try (Session sessao = HibernateUtil.getSessao().openSession();) {
            tx = sessao.beginTransaction();
            sessao.persist(fornecedor);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Fracassamos ao tentar obter sucesso!" + e);
        }
    }

    public void atualizar(FornecedorEntity fornecedor) {
        Transaction tx = null;
        try (Session sessao = HibernateUtil.getSessao().openSession();) {
            tx = sessao.beginTransaction();
            FornecedorEntity verifica = sessao.merge(fornecedor);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Fracassamos ao tentar obter sucesso!" + e);
        }
    }

    public FornecedorEntity buscar(Long id) {
        try (Session sessao = HibernateUtil.getSessao().openSession();) {
            return sessao.find(FornecedorEntity.class, id);
        }
    }

    public List<FornecedorEntity> listar() {
        try (Session sessao = HibernateUtil.getSessao().openSession();) {
            return sessao.createQuery("From FornecedorEntity", FornecedorEntity.class).list();
        }
    }

    public void deletar(Long id) {
        Transaction tx = null;
        try (Session sessao = HibernateUtil.getSessao().openSession();) {
            tx = sessao.beginTransaction();
            FornecedorEntity fornecedor = sessao.find(FornecedorEntity.class, id);
            sessao.remove(fornecedor);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            System.err.println("Fracassamos ao tentar obter sucesso!" + ex);
        }
    }
}
