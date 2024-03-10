package Java.javaApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

class Account {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<Transaction> transactions;

    public Account(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void displayTransactions() {
        System.out.println("Transaction History for Account " + accountNumber);
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getType() + ": " + transaction.getAmount());
        }
    }
}

class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}

public class BankAppUsingOops {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Account account1 = new Account(1, "John Doe");
        Account account2 = new Account(2, "Jane Doe");

        bank.addAccount(account1);
        bank.addAccount(account2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Transactions");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter account number: ");
                    int depositAccountNumber = scanner.nextInt();
                    Account depositAccount = bank.findAccount(depositAccountNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        depositAccount.deposit(depositAmount);
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter account number: ");
                    int withdrawAccountNumber = scanner.nextInt();
                    Account withdrawAccount = bank.findAccount(withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter account number: ");
                    int displayAccountNumber = scanner.nextInt();
                    Account displayAccount = bank.findAccount(displayAccountNumber);
                    if (displayAccount != null) {
                        displayAccount.displayTransactions();
                    } else {
                        System.out.println("Account not found.");
                    }
                }
                case 4 -> {
                    System.out.println("Exiting the bank application. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
