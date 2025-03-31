import java.util.ArrayList;

public class TaskManagementSystem {
    private Task head;
    private Task normalTail;
    private Task priorityTail;
    private int size;
    private int prioritySize;
    private ArrayList<String> processedTasks;

    public TaskManagementSystem(){
        this.size = 0;
        this.prioritySize = 0;
        this.head = null;
        this.normalTail = null;
        this.priorityTail = null;
        this.processedTasks = new ArrayList<>();
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void pushTask(Task newTask){
        if (head == null){
            head = newTask;
            normalTail = head;
            size ++;
            if (newTask.isPriority){
                priorityTail = head;
                prioritySize ++;
            }
        }
        else {
            if (newTask.isPriority){
                if (priorityTail == null){
                    newTask.next = head;
                    head.prev = newTask;
                    head = newTask;
                    priorityTail = newTask;
                }
                else {
                    Task firstNormalTask = priorityTail.next;
                    newTask.next = firstNormalTask;
                    newTask.prev = priorityTail;
                    priorityTail.next = newTask;

                    if (firstNormalTask != null){
                        firstNormalTask.prev = newTask;
                    }

                    priorityTail = newTask;

                    if (size == prioritySize){
                        normalTail = newTask;
                    }
                }
                prioritySize ++;
            }
            else {
                normalTail.next = newTask;
                newTask.prev = normalTail;
                normalTail = newTask;
            }
            size ++;
        }
    }

    public void pop(boolean keepTask) throws Exception {
        if (isEmpty()){
            throw new Exception("No Task Found!");
        }
        else {
            Task taskProcessed = head;
            head = head.next;
            size --;
            System.out.println(taskProcessed + " succesfuly processed!");
            if (keepTask){
                processedTasks.add(taskProcessed.getName());
            }
        }
    }

    public void displayProcessedTask(){
        assert processedTasks != null;
        for (String processedTask : processedTasks){
            System.out.println(processedTask + ", ");
        }
    }

    public void displayTasks(){
        Task currentTask = head;
        while(currentTask != null){
            System.out.println(currentTask);
            currentTask = currentTask.next;
        }
    }
}
