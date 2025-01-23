import java.util.Scanner; //ATM Interface

class Account {
    private double currentBalance;

    public Account(double initialBalance) {
        currentBalance = initialBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void addFunds(double amount) {
        currentBalance += amount;
    }

    public boolean deductFunds(double amount) {
        if (amount <= currentBalance) {
            currentBalance -= amount;
            return true;
        }
        return false;
    }
}

class ATMSystem {
    private Account accountHolder;

    public ATMSystem(Account userAccount) {
        accountHolder = userAccount;
    }

    public void showMenu() {
        System.out.println("=== ATM Options ===");
        System.out.println("1. View Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    public void start() {
        Scanner input = new Scanner(System.in);

        while (true) {
            showMenu();
            System.out.print("Choose an option: ");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Your current balance is: Rs. " + accountHolder.getCurrentBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    accountHolder.addFunds(depositAmount);
                    System.out.println("Deposit successful! Your updated balance is: Rs. " + accountHolder.getCurrentBalance());
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawalAmount = input.nextDouble();
                    if (accountHolder.deductFunds(withdrawalAmount)) {
                        System.out.println("Withdrawal successful! Your updated balance is: Rs. " + accountHolder.getCurrentBalance());
                    } else {
                        System.out.println("Insufficient funds in your account.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Account user = new Account(1000); 
        ATMSystem atmSystem = new ATMSystem(user);
        atmSystem.start();
    }
}
