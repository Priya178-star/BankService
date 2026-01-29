import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: " + amount);
        } else {
            System.out.println("❌ Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance!");
        } else {
            System.out.println("❌ Withdrawal amount must be positive.");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("💰 Current Balance: " + balance);
    }
}

public class BankService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create account with initial balance
        BankAccount account = new BankAccount("Alice", 1000.0);

        int choice;
        do {
            System.out.println("\n--- Bank Service Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("👋 Exiting... Thank you!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
