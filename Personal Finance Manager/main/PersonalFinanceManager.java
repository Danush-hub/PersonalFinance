package main;

import models.Transaction;
import services.FinanceService;
import services.FinanceServiceImpl;
import exceptions.TransactionNotFoundException;

import java.time.LocalDate;

public class PersonalFinanceManager {
    public static void main(String[] args) {
        FinanceService financeService = new FinanceServiceImpl();

        Transaction income1 = new Transaction(1, "income", 1000, LocalDate.now(), "Salary");
        Transaction income2 = new Transaction(3, "income", 1500, LocalDate.now().minusDays(10), "Freelancing");
        Transaction expense1 = new Transaction(2, "expense", 200, LocalDate.now(), "Groceries");
        Transaction expense2 = new Transaction(4, "expense", 300, LocalDate.now().minusDays(5), "Utility Bills");

        financeService.addTransaction(income1);
        financeService.addTransaction(income2);
        financeService.addTransaction(expense1);
        financeService.addTransaction(expense2);

        System.out.println("Transactions after adding:");
        financeService.displayTransactions();

        try {
            financeService.removeTransaction(2);  // Removing the expense transaction
        } catch (TransactionNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTransactions after removing transaction with ID 2:");
        financeService.displayTransactions();

        System.out.println("\nTotal Income: " + financeService.getTotalIncome());
        System.out.println("Total Expense: " + financeService.getTotalExpense());
        System.out.println("Balance: " + financeService.getBalance());
    }
}
