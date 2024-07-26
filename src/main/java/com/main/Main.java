package com.main;

import com.dto.BankAccount;
import com.service.BankAccountService;
import com.service.BankAccountServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final BankAccountService service = new BankAccountServiceImpl();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //createAccounts();

        System.out.println("1. CRUD Operation");
        System.out.println("2. Find account by Account number");
        System.out.println("3. Find by Customer name");
        System.out.println("4. Find account by Branch code");
        System.out.println("5. Find by Group by");

        System.out.print("Enter operation you want to perform: ");
        int operation = sc.nextInt();

        switch (operation) {
            case 1:
                System.out.println("1. Create 2. Read 3. Update 4. Delete");
                int crudOperation = sc.nextInt();
                switch (crudOperation) {
                    case 1:
                        // create accounts
                        createAccounts();
                        System.out.println("Accounts created.");
                        break;
                    case 2:
                        // read account
                        System.out.print("Enter account number to read: ");
                        int readAccountNumber = sc.nextInt();
                        BankAccount readAccount = service.readAccount(readAccountNumber);
                        System.out.println("Read Account: " + readAccount);
                        break;
                    case 3:
                        // update account
                        System.out.print("Enter account number to update: ");
                        int updateAccountNumber = sc.nextInt();
                        BankAccount updateAccount = service.readAccount(updateAccountNumber);
                        if (updateAccount != null) {
                            System.out.print("Enter new balance: ");
                            double newBalance = sc.nextDouble();
                            updateAccount.setActBalance(newBalance);
                            service.updateAccount(updateAccount);
                            System.out.println("Account updated.");
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;
                    case 4:
                        // delete account
                        System.out.print("Enter account number to delete: ");
                        int deleteAccountNumber = sc.nextInt();
                        service.deleteAccount(deleteAccountNumber);
                        System.out.println("Account deleted.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                break;
            case 2:
                // Find account by Account number
                System.out.print("Enter account number to find: ");
                int findAccountNumber = sc.nextInt();
                BankAccount accountByNumber = service.readAccount(findAccountNumber);
                System.out.println("Account details: " + accountByNumber);
                break;
            case 3:
                // Find by name
                System.out.print("Enter customer name to find: ");
                sc.nextLine(); // Consume newline
                String customerName = sc.nextLine();
                List<BankAccount> accountsByCustomerName = service.findByCustomerName(customerName);
                System.out.println("Accounts for " + customerName + ": " + accountsByCustomerName);
                break;
            case 4:
                // Find by Branch code
                System.out.print("Enter branch code to find: ");
                int branchCode = sc.nextInt();
                List<BankAccount> accountsByBranchCode = service.findByBranchCode(branchCode);
                System.out.println("Accounts for branch code " + branchCode + ": " + accountsByBranchCode);
                break;
            case 5:
                // Find by Group by
                List<BankAccount> groupedAccounts = service.findAllAccountsGroupedBy();
                System.out.println("Grouped Accounts: " + groupedAccounts);
                break;
            default:
                System.out.println("Invalid operation.");
                break;
        }
    }

    private static void createAccounts() {
        service.createAccount(new BankAccount(1001, "Rahul1", 1800, "Chennai", 101));
        service.createAccount(new BankAccount(1003, "Rahul3", 2500, "Chennai", 101));
        service.createAccount(new BankAccount(1004, "Rahul1", 2900, "Chennai", 103));

        service.createAccount(new BankAccount(1002, "Rahul8", 1000, "Bengaluru", 102));
        service.createAccount(new BankAccount(1005, "Rahul8", 3200, "Bengaluru", 102));
        service.createAccount(new BankAccount(1008, "Rahul8", 3700, "Bengaluru", 103));
        service.createAccount(new BankAccount(1009, "Rahul9", 3700, "Bengaluru", 103));

        service.createAccount(new BankAccount(1006, "Rahul6", 3700, "Faridabad", 103));
        service.createAccount(new BankAccount(1007, "Rahul6", 3700, "Faridabad", 103));
        service.createAccount(new BankAccount(1010, "Rahul1", 3700, "Faridabad", 103));
    }
}
