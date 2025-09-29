package com.leevilaune.currency.dao;

import com.leevilaune.currency.datasource.MariaDbJpaConnection;
import com.leevilaune.currency.entity.Currency;
import com.leevilaune.currency.entity.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDao {

    public void persist(Currency currency1, Currency currency2, double amount) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(new Transaction(currency1,currency2,amount));
        em.getTransaction().commit();
    }
}
