package com.service;

import com.dto.BankAccount;
import java.util.List;

public interface BankAccountService {
    void createAccount(BankAccount account);
    BankAccount readAccount(int actNumber);
    void updateAccount(BankAccount account);
    void deleteAccount(int actNumber);
    List<BankAccount> findByCustomerName(String customerName);
    List<BankAccount> findByBranchCode(int branchCode);
    List<BankAccount> findAllAccountsGroupedBy();
}

