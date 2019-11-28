package com.alex.dao;

import com.alex.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //inject the session factory (dependency injection for talking to hibernate. matches <bean id=sessionFactory)
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {

//        get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

//        create a query, sort by last name
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

//        execute query and get result list
        List<Customer> customers = theQuery.getResultList();

//        return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();

        //save or update customer into the db
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        //Query<Customer> theQuery = currentSession.createQuery("from Customer WHERE id='theId' ");

        Customer theCustomer = currentSession.get(Customer.class, theId);
        return theCustomer;
    }

}
