package queue;

import java.util.ArrayList;

public class Queue {
    
    public static ArrayList<task> queue = new ArrayList<>();
    public static task newTask;

    public static void main(String[] args) {
        enqueue("Dont Die",5);
        enqueue("Sleep",2);
        enqueue("Eat",3);
        enqueue("Drink water",4);
        
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.get(i).getTaskName());
        }
    }
    
    public static void enqueue(String taskName, int priority) {
        boolean taskMadeAlready = false;
        for (int i = 0; i < queue.size(); i++) {
            if(queue.get(i).getTaskName().equalsIgnoreCase(taskName)) {
                taskMadeAlready = true;
            }
        }
        
        if ((priority <= 0) || (priority >= 6)) {
            System.out.print("Your priority value for '" + taskName + "' was not valid");
            System.exit(0);
        }
        
        if ((taskMadeAlready == false) && (queue.size() < 2)) {
            newTask = new task(taskName, priority);
            if(queue.isEmpty()) {
                queue.add(newTask);
            }
            else {
                if (priority <= queue.get(0).getPriority()) {
                    queue.add(0, newTask);
                }
                else {
                    queue.add(newTask);
                }
            }
        }

        else if (taskMadeAlready == false) {
            int position = -1;

            for (int i = 0; i < queue.size(); i++) {
                if(priority <= queue.get(i).getPriority()) {
                    position = i;
                    break;
                }
            }
            
            newTask = new task(taskName, priority);
            
            if (position != -1) {
                for (int i = queue.size(); i >= position; i--) {
                    if (i == queue.size()) {
                        queue.add(queue.get(i-1));
                    }
                    else {
                        queue.set(i+1, queue.get(i)); 
                    }
                }

                queue.set(position, newTask);
            }
            else {
                queue.add(newTask);
            }

            
        }
        else {
            System.out.println("The task you are trying to list has already been listed");
        }
    }
    
    public static void dequeue(String taskName) {
        boolean found = false;
        int position = -1;
        for (int i = 0; i < queue.size(); i++) {
            if (taskName.equalsIgnoreCase(queue.get(i).getTaskName())) {
                found = true;
                position = i;
                break;
            }
        }
        
        if (found == true) {
            queue.remove(position);
        }
        else if (queue.isEmpty()) {
            System.out.println("You cant remove this task as the queue is empty");
        }
        else {
            System.out.println("This task is not in the queue");
        }
    }      
}
