package com.leevilaune.currency.dao;

import com.leevilaune.currency.datasource.MariaDbJpaConnection;
import com.leevilaune.currency.entity.*;
import jakarta.persistence.EntityManager;

import javax.swing.plaf.ColorUIResource;
import java.util.List;

public class CurrencyDao {

    public void persist(Currency curr) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(curr);
        em.getTransaction().commit();
    }

    public Currency find(int id) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        if(em == null){
            return null;
        }
        return em.find(Currency.class, id);
    }
    public Currency find(String code){
        EntityManager em = MariaDbJpaConnection.getInstance();
        if(em == null){
            return null;
        }
        return em.createQuery("select c from Currency c where c.code = :code", Currency.class)
                .setParameter("code", code)
                .getSingleResult();
    }

    public List<Currency> findAll() {
        EntityManager em = MariaDbJpaConnection.getInstance();
        if(em == null){
            return null;
        }
        List<Currency> emps = em.createQuery("select c from Currency c").getResultList();
        return emps;
    }

    public void update(Currency curr) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        if(em == null){
            return;
        }
        em.getTransaction().begin();
        em.merge(curr);
        em.getTransaction().commit();
    }

    public void delete(Currency curr) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        if(em == null){
            return;
        }
        em.getTransaction().begin();
        em.remove(curr);
        em.getTransaction().commit();
    }
}
