package dao;

import entity.CadastroEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author u11249767105
 */
public class CadastroDAO {

    public void salvar(CadastroEntity cadastro) {
        Transaction tx = null;
        try (Session sessao = HibernateUtil.getSessao().openSession();) {
            tx = sessao.beginTransaction();
            sessao.persist(cadastro);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Fracassamos ao tentar obter sucesso!" + e);
        }
    }

    public void atualizar(CadastroEntity cadastro) {
        Transaction tx = null;
        try (Session sessao = HibernateUtil.getSessao().openSession();) {
            tx = sessao.beginTransaction();
            CadastroEntity verifica = sessao.merge(cadastro);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Fracassamos ao tentar obter sucesso!" + e);
        }
    }

    public CadastroEntity buscar(Long id) {
        try (Session sessao = HibernateUtil.getSessao().openSession();) {
            return sessao.find(CadastroEntity.class, id);
        }
    }

    public List<CadastroEntity> listar() {
        try (Session sessao = HibernateUtil.getSessao().openSession();) {
            return sessao.createQuery("From CadastroEntity", CadastroEntity.class).list();
        }
    }

    public void deletar(Long id) {
        Transaction tx = null;
        try (Session sessao = HibernateUtil.getSessao().openSession();) {
            tx = sessao.beginTransaction();
            CadastroEntity cadastro = sessao.find(CadastroEntity.class, id);
            sessao.remove(cadastro);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            System.err.println("Fracassamos ao tentar obter sucesso!" + ex);
        }
    }

    public CadastroEntity buscar(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}