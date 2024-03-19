/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpcustomerraharimanantena.service;

import com.mycompany.tpcustomerraharimanantena.entity.Customer;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;

/**
 * Façade pour gérer les Customers.
 *
 * @author Diary
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Récupère tous les clients de la base de données.
     * @return 
     */
    public List<Customer> getAllCustomers() {
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }

    /**
     * Met à jour un client existant dans la base de données
     * @param customer
     * @return 
     */
    @Transactional
    public Customer update(Customer customer) {
       return em.merge(customer);
    }
    
    /**
     * Enregistre un nouveau client dans la base de données
     * @param customer 
     */
    @Transactional
    public void persist(Customer customer) {
       em.persist(customer);
    }
}
