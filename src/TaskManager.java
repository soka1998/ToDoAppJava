import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<String> tasks;
    private Scanner scanner;

    public TaskManager() {
        // Create an empty ArrayList to store the tasks (each task is a String)
        tasks = new ArrayList<>();

        // Create a Scanner object to read user input from the console
        scanner = new Scanner(System.in);

    }

    public void showMenu() {
        System.out.println("\n==== TO DO LIST ====");
        System.out.println("1.Add a Task ");
        System.out.println("2.Show Tasks");
        System.out.println("3.Delete a task ");
        System.out.println("4.Leave ");
        System.out.println(" Your Choice please : ");
    }

    public void addTask() {
        System.out.println("Enter the task name:");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("✅ Task added successfully!");

    }

    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println(" ⚠\uFE0F No tasks yet.");
        } else {
            System.out.println("  \uD83D\uDCCB Task list: ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }

    }

    public void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("⚠\uFE0F No task to delete.");
        } else {
            System.out.println(" Enter the number of the task to delete:");
            int num = scanner.nextInt();
            scanner.nextLine();
            if (num > 0 && num <= tasks.size()) {
                tasks.remove(num - 1);
                System.out.println(" ✅ Task deleted!");
            } else {
                System.out.println(" ❌ Invalid number.");
            }
        }

    }

    public void start() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                addTask();
            } else if (choice == 2) {
                showTasks();
            } else if (choice == 3) {
                deleteTask();
            } else if (choice == 4) {
                System.out.println(" \uD83D\uDC4B Goodbye!");
                break;
            } else {
                System.out.println("❌ Invalid choice.");
            }
        }
        scanner.close();
    }
}



