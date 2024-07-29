package services;

import models.Transaction;
import models.FinanceManager;
import exceptions.TransactionNotFoundException;

public class FinanceServiceImpl implements FinanceService {
    private FinanceManager financeManager;

    public FinanceServiceImpl() {
        this.financeManager = new FinanceManager();
    }

    @Override
    public void addTransaction(Transaction transaction) {
        financeManager.addTransaction(transaction);
    }

    @Override
    public void removeTransaction(int transactionId) throws TransactionNotFoundException {
        Transaction transaction = financeManager.getTransaction(transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction with ID " + transactionId + " not found");
        }
        financeManager.removeTransaction(transactionId);
    }

    @Override
    public double getTotalIncome() {
        return financeManager.getTotalIncome();
    }

    @Override
    public double getTotalExpense() {
        return financeManager.getTotalExpense();
    }

    @Override
    public double getBalance() {
        return financeManager.getBalance();
    }

    @Override
    public void displayTransactions() {
        financeManager.displayTransactions();
    }
}
