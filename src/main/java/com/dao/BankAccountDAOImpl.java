package com.dao;

import com.dto.BankAccount;
import jakarta.persistence.*;

import java.util.List;

public class BankAccountDAOImpl implements BankAccountDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Midterm");

    @Override
    public void createAccount(BankAccount account) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(account);
        et.commit();
        em.close();
    }

    @Override
    public BankAccount readAccount(int actNumber) {
        EntityManager em = emf.createEntityManager();
        BankAccount account = em.find(BankAccount.class, actNumber);
        em.close();
        return account;
    }

    @Override
    public void updateAccount(BankAccount account) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(account);
        et.commit();
        em.close();
    }

    @Override
    public void deleteAccount(int actNumber) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        BankAccount account = em.find(BankAccount.class, actNumber);
        if (account != null) {
            em.remove(account);
        }
        et.commit();
        em.close();
    }

    @Override
    public List<BankAccount> findByCustomerName(String customerName) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT b FROM BankAccount b WHERE b.customerName = :customerName", BankAccount.class);
        q.setParameter("customerName", customerName);
        List<BankAccount> accounts = q.getResultList();
        em.close();
        return accounts;
    }

    @Override
    public List<BankAccount> findByBranchCode(int branchCode) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT b FROM BankAccount b WHERE b.branchCode = :branchCode", BankAccount.class);
        q.setParameter("branchCode", branchCode);
        List<BankAccount> accounts = q.getResultList();
        em.close();
        return accounts;
    }

    @Override
    public List<BankAccount> findAllAccountsGroupedBy() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT b FROM BankAccount b GROUP BY b.actNumber, b.customerName, b.city", BankAccount.class);
        List<BankAccount> accounts = query.getResultList();
        em.close();
        return accounts;
    }
}
