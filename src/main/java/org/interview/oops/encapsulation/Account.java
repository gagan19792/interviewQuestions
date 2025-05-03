package org.interview.oops.encapsulation;

//Definition:
//Encapsulation is the practice of bundling an object’s state (its fields) and the methods that operate on that state into
// a single unit (the class), and restricting direct access to some of an object’s components. This protects the integrity of the data.
public class Account {
    private String owner;
    private double balance;

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    // business logic enforces invariants
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }

}
