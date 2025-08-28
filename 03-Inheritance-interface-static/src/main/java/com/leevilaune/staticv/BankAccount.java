package com.leevilaune.staticv;

public class BankAccount {
    // Your variable declarations and code here
    private static int totalAccounts;
    private int balance;
    private int accountNumber;

    public BankAccount(int accountNumber){
        totalAccounts++;
        this.balance = accountNumber;
        this.accountNumber = totalAccounts;
    }

    public void deposit(int amount){
        if(amount < 0){
            return;
        }
        this.balance += amount;
    }

    public void withdraw(int amount){
        if(amount < 0){
            return;
        }
        this.balance -= amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}