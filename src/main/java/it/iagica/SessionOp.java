package it.iagica;

import org.hibernate.Session;

public class SessionOp {

    private static Session session = HibernateFactory.getFactory().openSession();


    private SessionOp(){}
    public static Session getInstance(){
        return session;
    }
}
