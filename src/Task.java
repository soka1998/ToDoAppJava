
// This class represents a single task in the to-do list
public class Task {
    private String title;

    // A flag to indicate whether the task is completed or not
    private boolean isDone;

    // Constructor: creates a new Task with a given title, initially not done
    public Task(String title){
        this.title= title;
        this.isDone=false;
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

    // This method defines how the task will be displayed as a string
    // If it's done, it shows a ✔, otherwise an empty box
    @Override
    public  String toString(){
        return (isDone ? "[✔] ":"[ ] ")+ title;
    }


}
