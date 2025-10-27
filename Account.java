package BankingSystem;

import java.util.*;

public class Account {
    private static int counter = 1;
    private int accountNumber;
    private String firstName;
    private String lastName;
    private long amount;
    private List<String> transactionHistory = new ArrayList<>();

    public Account(String firstName, String lastName, long amount) {
        this.accountNumber = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        transactionHistory.add("Account created with initial balance " + amount);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(long amt) {
        if (amt > 0) {
            this.amount += amt;
            transactionHistory.add("Deposited: " + amt + " | New Balance: " + this.amount);
            System.out.println("Successfully deposited " + amt + ". New balance: " + this.amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }


    public void withdraw(long amt) {
        if (amt > 0 && amt <= this.amount) {
            this.amount -= amt;
            transactionHistory.add("Withdrew: " + amt + " | New Balance: " + this.amount);
            System.out.println("Withdrawal successful! Remaining balance: " + this.amount);
        } else if (amt > this.amount) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}
