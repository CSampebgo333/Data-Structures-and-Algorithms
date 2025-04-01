public class ManagementSystem {
    private TaskNode head;
    private TaskNode tail;
    private TaskNode pTail;
    private int size;
    private int pSize;
    private TaskNode processedHead;
    private TaskNode processedTail;
    private int processedTaskSize;

    public ManagementSystem(){
        head = null;
        tail = null;
        pTail = null;
        size = 0;
        pSize = 0;
        processedHead = null;
        processedTail = null;
        processedTaskSize = 0;
    }

    public void push(TaskNode task){
        if (head == null){
            head = task;
            tail = head;
            size ++;
            if (task.isPriority){
                pTail = task;
                pSize ++;
            }
        }
        else {
            if (task.isPriority){
                if (pTail == null){
                    task.next = head;
                    head.prev = task;
                    head = task;
                    pTail = task;
                }
                else {
                    TaskNode firstNormaltask = pTail.next;
                    task.next = firstNormaltask;
                    pTail.next = task;
                    task.prev = pTail;

                    if (firstNormaltask != null){
                        firstNormaltask.prev = task;
                    }
                    pTail = task;

                    if (size == pSize){
                        tail = pTail;
                    }
                }
                pSize ++;
            }
            else {
                tail.next = task;
                task.prev = tail;
                tail = task;
            }
            size ++;
        }
    }

    public void pop(boolean mustKeep){
        TaskNode processedTask = head;
        head = head.next;
        processedTask.next = null;
        processedTask.prev = null;
        if(processedTask.isPriority){
            pSize --;
        }
        size --;

        if (mustKeep){
            if (processedHead == null){
                processedHead = processedTask;
                processedTail = processedHead;
                processedTaskSize ++;
            }
            else {
                processedTail.next = processedTask;
                processedTask.prev = processedTail;
                processedTail = processedTask;
                processedTaskSize ++;
            }
        }
    }

    public void displayAll() throws Exception {
        TaskNode currentTask = head;
        if (currentTask == null){
            throw new Exception("No Task To Display");
        }
        while (currentTask != null){
            System.out.println(currentTask);
            currentTask = currentTask.next;
        }
    }

    public void displayProcessedTask() throws Exception {
        TaskNode cTask = processedHead;
        if (cTask == null){
            throw new Exception("ZERO TASK PROCESSED");
        }
        while (cTask != null){
            System.out.println(cTask);
            cTask = cTask.next;
        }
    }

    public int getTotalTaskSize(){
        return size;
    }

    public int getPriorityTaskSize(){
        return pSize;
    }

    public int getProcessedTaskSize(){
        return processedTaskSize;
    }
}
