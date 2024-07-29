package services;

import models.Transaction;
import exceptions.TransactionNotFoundException;

public interface FinanceService {
    void addTransaction(Transaction transaction);
    void removeTransaction(int transactionId) throws TransactionNotFoundException;
    double getTotalIncome();
    double getTotalExpense();
    double getBalance();
    void displayTransactions();
}
