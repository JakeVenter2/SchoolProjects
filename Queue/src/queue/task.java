package queue;

public class task {
    public String taskName;
    public int priority;

    public task(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getPriority() {
        return priority;
    }
}
