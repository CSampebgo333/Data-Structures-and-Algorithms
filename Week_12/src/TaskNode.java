public class TaskNode {
    private String name;
    public boolean isPriority;
    public TaskNode next;
    public TaskNode prev;

    public TaskNode(String name){
        this.name = name;
        this.isPriority = false;
        this.next = null;
        this.prev = null;
    }

    public TaskNode(String name, boolean isPriority){
        this.name = name;
        this.isPriority = isPriority;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        if (isPriority){
            return "Task {name: " + name + " *}" ;
        }
        return "Task {name: " + name + "}";
    }
}
