import java.util.ArrayList;
import java.util.Scanner;
class Expense {
    private String category;
    private double amount;
    private String date;

    public Expense(String category, double amount, String date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Category: " + category +
               ", Amount: Rs." + amount +
               ", Date: " + date;
    }
}

public class PersonalExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== PERSONAL EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Date (DD-MM-YYYY): ");
                    String date = sc.nextLine();

                    expenses.add(new Expense(category, amount, date));
                    System.out.println("Expense Added Successfully!");
                    break;

                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses found.");
                    } else {
                        System.out.println("\n--- Expense List ---");
                        for (Expense expense : expenses) {
                            System.out.println(expense);
                        }
                    }
                    break;

                case 3:
                    double total = 0;

                    for (Expense expense : expenses) {
                        total += expense.getAmount();
                    }

                    System.out.println("Total Expenses: Rs." + total);
                    break;

                case 4:
                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}