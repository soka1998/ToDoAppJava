import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// This class manages the list of tasks and handles user interaction
public class TaskManager {
    // A list to store all the Task objects
    private ArrayList<Task> tasks;

    // Scanner to read input from the user
    private Scanner scanner;

    // Constructor: initializes the task list and scanner
    public TaskManager() {
        // Create an empty ArrayList to store the tasks (each task is a String)
        tasks = new ArrayList<>();

        // Create a Scanner object to read user input from the console
        scanner = new Scanner(System.in);

    }
    // Displays the menu options to the user
    public void showMenu() {
        System.out.println("\n==== TO DO LIST ====");
        System.out.println("1.Add a Task ");
        System.out.println("2.Show Tasks");
        System.out.println("3.Delete a task ");
        System.out.println("4.Leave ");
        System.out.println("5. Mark task as done");
        System.out.println(" Your Choice please : ");
    }
    // Adds a new task entered by the user
    public void addTask() {
        System.out.println("Enter the task name:");
        String title = scanner.nextLine();

        Priority priority = null ;
        while (priority == null ){
            System.out.println(" select priority : ");
            System.out.println(" 1.HIGH");
            System.out.println(" 2.MEDIUM ");
            System.out.println(" 3.Low ");
            System.out.println(" Your choice (1/2/3): ");
            String input = scanner.nextLine();

            switch(input){
                case "1":
                    priority=Priority.HIGH;
                    break;
                case "2":
                    priority = Priority.MEDIUM;
                    break;
                case "3":
                    priority = Priority.LOW;
                    break;
                default:
                    System.out.println(" Invalid choice.Please enter 1,2,or 3 ");
            }
        }


        Task task = new Task(title,priority); // Create a new Task object
        tasks.add(task);// Add it to the task list
        System.out.println("✅ Task added successfully!");

    }
    // Displays all tasks with their status (done or not)
    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println(" ⚠\uFE0F No tasks yet.");
        } else {
            // Sort tasks by priority before displaying
            tasks.sort(Comparator.comparing(Task::getPriority));

            System.out.println("  \uD83D\uDCCB Task list (sorted by priority : ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }

    }
    // Deletes a task selected by the user
    public void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("⚠\uFE0F No task to delete.");
        } else {
            showTasks(); // Show tasks before asking for input
            System.out.println(" Enter the number of the task to delete:");
            int num = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (num > 0 && num <= tasks.size()) {
                tasks.remove(num - 1); // Remove task by index
                System.out.println(" ✅ Task deleted!");
            } else {
                System.out.println(" ❌ Invalid number.");
            }
        }

    }
    // Marks a task as done, based on the user's choice
    public void markTaskAsDone(){
        showTasks();
        if(!tasks.isEmpty()){
            System.out.println("Enter task number to mark as done");
            int num = scanner.nextInt();
            scanner.nextLine();
            if (num >0 && num <= tasks.size()){
                tasks.get(num - 1).markAsDone(); // Use the Task method
                System.out.println("Task marked as done !");
            }else{
                System.out.println("❌ Invalid number.");
            }
        }
    }
    // Main loop: shows the menu and handles user choices
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
            }
            else if (choice == 5 ){
                markTaskAsDone();
            } else {
                System.out.println("❌ Invalid choice.");
            }
        }
        scanner.close();// Close the scanner when the loop ends
    }
}



