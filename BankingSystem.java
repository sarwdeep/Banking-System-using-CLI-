package BankingSystem;

import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        int operation;

        while (exit) {
            System.out.println("\nEnter the Operation you want to perform: ");
            System.out.println("1) Add an account");
            System.out.println("2) View Account details");
            System.out.println("3) Deposit Amount");
            System.out.println("4) Withdraw Amount");
            System.out.println("5) Delete Account");
            System.out.println("6) View Transaction History");
            System.out.println("7) Exit");

            System.out.print("\nChoose an option: ");
            operation = scanner.nextInt();
            scanner.nextLine();

            switch (operation) {
                case 1:
                    System.out.print("Enter Account holder's first name: ");
                    String firstname = scanner.nextLine();
                    System.out.print("Enter Account holder's last name: ");
                    String lastname = scanner.nextLine();
                    System.out.print("Enter Initial Amount: ");
                    long amount = scanner.nextLong();
                    scanner.nextLine();

                    addAccount(accountList, firstname, lastname, amount);
                    System.out.println("Account added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int accNum = scanner.nextInt();
                    Account acc = findAccount(accountList, accNum);
                    if (acc != null) {
                        System.out.println("\n=== Account Details ===");
                        System.out.println("Account Number: " + acc.getAccountNumber());
                        System.out.println("Name: " + acc.getFirstName() + " " + acc.getLastName());
                        System.out.println("Balance: " + acc.getAmount());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNum = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    long depositAmt = scanner.nextLong();
                    acc = findAccount(accountList, accNum);
                    if (acc != null) {
                        acc.deposit(depositAmt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNum = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    long withdrawAmt = scanner.nextLong();
                    acc = findAccount(accountList, accNum);
                    if (acc != null) {
                        acc.withdraw(withdrawAmt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number to delete: ");
                    accNum = scanner.nextInt();
                    Account toRemove = findAccount(accountList, accNum);
                    if (toRemove != null) {
                        accountList.remove(toRemove);
                        System.out.println("Account deleted successfully!");
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    System.out.print("Enter Account Number: ");
                    accNum = scanner.nextInt();
                    acc = findAccount(accountList, accNum);
                    if (acc != null) {
                        System.out.println("\nTransaction History");
                        for (String t : acc.getTransactionHistory()) {
                            System.out.println(t);
                        }
                        if (acc.getTransactionHistory().isEmpty()) {
                            System.out.println("No transactions found.");
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 7:
                    System.out.println("Exiting... Thank you for using Java Bank!");
                    exit = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again!");
                    break;
            }
        }

        scanner.close();
    }

    static void addAccount(List<Account> accountList, String firstname, String lastname, long amount) {
        Account account = new Account(firstname, lastname, amount);
        accountList.add(account);
    }

    static Account findAccount(List<Account> list, int accountNumber) {
        for (Account acc : list) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }
}
