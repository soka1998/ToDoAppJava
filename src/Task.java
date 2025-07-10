import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// This class represents a single task in the to-do list
public class Task {
    private String title;
    private Priority priority;

    // A flag to indicate whether the task is completed or not
    private boolean isDone;
    private LocalDateTime createdAt ; //  Task Add Time



    //Format to show the date nicely
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd MMM yyy - HH:mm");

    // Constructor: creates a new Task with a given title, initially not done
    public Task(String title ,Priority priority){
        this.title= title;
        this.priority= priority;
        this.isDone=false;
        this.createdAt=LocalDateTime.now(); // Time is automatically recorded.

    }
    // Marks this task as completed
    public void markAsDone(){

        isDone = true;
    }
    // Returns whether the task is done or not
    public boolean isDone(){
        return isDone;

    }
    // Returns the title of the task
    public String getTitle(){

        return title;
    }

    public Priority getPriority(){
        return priority;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    // This method defines how the task will be displayed as a string
    // If it's done, it shows a ✔, otherwise an empty box
    @Override
    public  String toString(){
        // Format the creation time using the formatter
        return (isDone ? "[✔] ":"[ ] ")+ title + " ( Priority : " + priority+" (added : " + createdAt.format(formatter)+ ")";
    }


}
