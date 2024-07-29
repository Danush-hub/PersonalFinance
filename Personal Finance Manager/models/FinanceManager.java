package models;

import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
    private List<Transaction> transactionList;

    public FinanceManager() {
        this.transactionList = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public void removeTransaction(int transactionId) {
        transactionList.removeIf(transaction -> transaction.getTransactionId() == transactionId);
    }

    public double getTotalIncome() {
        return transactionList.stream()
                .filter(transaction -> transaction.getType().equals("income"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getTotalExpense() {
        return transactionList.stream()
                .filter(transaction -> transaction.getType().equals("expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    public void displayTransactions() {
        transactionList.forEach(System.out::println);
    }

    public Transaction getTransaction(int transactionId) {
        return transactionList.stream()
                .filter(transaction -> transaction.getTransactionId() == transactionId)
                .findFirst()
                .orElse(null);
    }
}
