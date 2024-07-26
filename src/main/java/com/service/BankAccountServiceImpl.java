package com.service;

import com.dao.BankAccountDAO;
import com.dao.BankAccountDAOImpl;
import com.dto.BankAccount;

import java.util.List;

public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountDAO bankAccountDAO = new BankAccountDAOImpl();

    @Override
    public void createAccount(BankAccount account) {
        bankAccountDAO.createAccount(account);
    }

    @Override
    public BankAccount readAccount(int actNumber) {
        return bankAccountDAO.readAccount(actNumber);
    }

    @Override
    public void updateAccount(BankAccount account) {
        bankAccountDAO.updateAccount(account);
    }

    @Override
    public void deleteAccount(int actNumber) {
        bankAccountDAO.deleteAccount(actNumber);
    }

    @Override
    public List<BankAccount> findByCustomerName(String customerName) {
        return bankAccountDAO.findByCustomerName(customerName);
    }

    @Override
    public List<BankAccount> findByBranchCode(int branchCode) {
        return bankAccountDAO.findByBranchCode(branchCode);
    }

    @Override
    public List<BankAccount> findAllAccountsGroupedBy() {
        return bankAccountDAO.findAllAccountsGroupedBy();
    }
}
