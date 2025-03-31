public class Task {
    private String name;
    public Task next;
    public   Task prev;
    public boolean isPriority;

    public Task(String name, boolean isPriority){
        this.name = name;
        this.isPriority = isPriority;
        this.next = null;
        this.prev = null;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Task {name = " + this.name + " }";
    }
}
