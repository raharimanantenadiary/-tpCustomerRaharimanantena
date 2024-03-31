/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpcustomerraharimanantena.service;

import com.mycompany.tpcustomerraharimanantena.entity.Discount;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;

/**
 *
 * @author Diary
 */
@RequestScoped
public class DiscountManager {
    
    
    @PersistenceContext(unitName = "discountPU")
    private EntityManager em;
    
    public Discount findById(String code){
        return em.find(Discount.class, code);
    }
    
    public List<Discount> getAllDiscounts(){
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }
}
