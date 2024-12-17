import java.util.Scanner;
class Account {
    String name;
    int accountNumber;
    double balance;
    String accountType;

    Account(String name, int accountNumber, String accountType, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

class SavAcct extends Account {
    double interestRate;

    SavAcct(String name, int accountNumber, double balance, double interestRate) {
        super(name, accountNumber, "Savings", balance);
        this.interestRate = interestRate;
    }

    void depositInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest Deposited: " + interest);
    }
}

class CurAcct extends Account {
    double minimumBalance;
    double serviceCharge;

    CurAcct(String name, int accountNumber, double balance, double minimumBalance, double serviceCharge) {
        super(name, accountNumber, "Current", balance);
        this.minimumBalance = minimumBalance;
        this.serviceCharge = serviceCharge;
    }

    void checkBalance() {
        if (balance < minimumBalance) {
            double penalty = serviceCharge;
            balance -= penalty;
            System.out.println("Minimum balance not maintained. Service charge of " + penalty + " applied.");
        }
    }

    void withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds to withdraw this amount while maintaining minimum balance.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter account type (Savings/Current): ");
        String accountType = sc.nextLine();

        System.out.println("Enter account holder's name: ");
        String name = sc.nextLine();
        
        System.out.println("Enter account number: ");
        int accountNumber = sc.nextInt();
        
        System.out.println("Enter initial balance: ");
        double balance = sc.nextDouble();

        Account account = null;
        if (accountType.equalsIgnoreCase("Savings")) {
            System.out.println("Enter interest rate: ");
            double interestRate = sc.nextDouble();
            account = new SavAcct(name, accountNumber, balance, interestRate);
        } else if (accountType.equalsIgnoreCase("Current")) {
            System.out.println("Enter minimum balance requirement: ");
            double minimumBalance = sc.nextDouble();
            System.out.println("Enter service charge: ");
            double serviceCharge = sc.nextDouble();
            account = new CurAcct(name, accountNumber, balance, minimumBalance, serviceCharge);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account Details");
            System.out.println("4. Compute and Deposit Interest (Savings only)");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    account.withdraw(withdrawalAmount);
                    if (account instanceof CurAcct) {
                        ((CurAcct) account).checkBalance();  
                    }
                    break;
                case 3:
                    account.displayDetails();
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).depositInterest();
                    } else {
                        System.out.println("Interest can only be calculated for savings accounts.");
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
        }
