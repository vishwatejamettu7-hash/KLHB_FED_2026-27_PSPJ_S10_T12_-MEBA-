import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    String description;
    double amount;

    Expense(String category, String description, double amount) {
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

    void display() {
        System.out.println(category + " | " + description + " | Rs. " + amount);
    }
}

public class MonthlyExpenseAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        System.out.print("Enter your monthly budget: Rs. ");
        double budget = sc.nextDouble();
        sc.nextLine();

        int choice;

        do {
            System.out.println("\n===== MONTHLY EXPENSE ANALYZER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Summary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter amount: Rs. ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    if (amount <= 0) {
                        System.out.println("Enter a valid amount!");
                    } else {
                        expenses.add(new Expense(category, description, amount));
                        System.out.println("Expense added successfully!");
                    }
                    break;

                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        System.out.println("\nCategory | Description | Amount");

                        for (Expense e : expenses) {
                            e.display();
                        }
                    }
                    break;

                case 3:
                    double total = 0;

                    for (Expense e : expenses) {
                        total += e.amount;
                    }

                    System.out.println("\nMonthly Budget: Rs. " + budget);
                    System.out.println("Total Expenses: Rs. " + total);
                    System.out.println("Remaining Budget: Rs. " + (budget - total));

                    if (total > budget) {
                        System.out.println("Warning: You exceeded your budget!");
                    } else {
                        System.out.println("You are within your budget.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Expense Analyzer!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
