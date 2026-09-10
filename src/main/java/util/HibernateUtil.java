package util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author u11249767105
 */
public class HibernateUtil {
    private static  final SessionFactory sessao = iniciarSessao();
    private static SessionFactory iniciarSessao(){
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * @return the sessao
     */
    public static SessionFactory getSessao() {
        return sessao;
    }
    
}
