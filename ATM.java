import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int PIN = 1234;
        int attempts = 0;
        int choice = 0;
        double balance = 1000;

        String[] history = new String[100];
        int count = 0;

        // Login
        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            int enteredPIN = input.nextInt();

            if (enteredPIN == PIN) {
                System.out.println("Login Successful!");
                break;
            } else {
                attempts++;
                System.out.println("Wrong PIN!");
            }
        }

        if (attempts == 3) {
            System.out.println("Account Locked!");
        } else {

            // Main Menu
            while (choice != 5) {

                System.out.println("\n1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transaction History");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                choice = input.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Balance: " + balance);
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        double deposit = input.nextDouble();

                        if (deposit > 0) {
                            balance += deposit;
                            history[count] = "Deposit: " + deposit;
                            count++;
                            System.out.println("Deposit Successful!");
                        } else {
                            System.out.println("Invalid Amount!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter amount: ");
                        double withdraw = input.nextDouble();

                        if (withdraw > 0 && withdraw <= balance) {
                            balance -= withdraw;
                            history[count] = "Withdraw: " + withdraw;
                            count++;
                            System.out.println("Withdrawal Successful!");
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                        break;

                    case 4:
                        System.out.println("Transaction History:");

                        for (int i = 0; i < count; i++) {
                            System.out.println(history[i]);
                        }
                        break;

                    case 5:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }
            }
        }

        input.close();
    }
}