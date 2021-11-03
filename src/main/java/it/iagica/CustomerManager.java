package it.iagica;


import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class CustomerManager {



    public CustomerManager() {

    }

    /**
     * Questo metodo accetta un oggetto di tipo Customer in input e lo salva sul database
     * @param customer il customer da salvare
     * @return boolean true se l'oggetto è stato salvato correttamente
     * */
    public boolean saveCustomer(Customer customer){
        SessionOp.getInstance().getTransaction().begin();
        Serializable obj = SessionOp.getInstance().save(customer);
        SessionOp.getInstance().getTransaction().commit();
        if(obj != null){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Questo metodo ritorna una lista di oggetti Customer
     * @return List<Customer> lista di customer
     * */
    public List<Customer> getAllCustomers(){
        SessionOp.getInstance().getTransaction().begin();
        List<Customer> customers = SessionOp.getInstance().createQuery("from Customer", Customer.class).getResultList();
        SessionOp.getInstance().getTransaction().commit();
        return customers;
    }
    public static Customer getUser(String usrn){
        Query query = SessionOp.getInstance().createQuery("FROM Customer u WHERE u.username=:usrn");
        query.setParameter("usrn", usrn);
        return (Customer) query.uniqueResult();
    }

}
