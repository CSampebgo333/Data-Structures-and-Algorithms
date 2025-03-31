public class Main{
    public static void main(String [] args) throws Exception {
        System.out.println("\"In class Assignment II\"\n");

        Task task1 = new Task("DSA Assignment", true);
        Task task2 = new Task("Intro to AI Project", true);
        Task task3 = new Task("Bring my cloths to the laundry", false);
        Task task4 = new Task("Reflect on Linear Algebra Project", true);
        Task task5 = new Task("Check Learners progress", false);

        TaskManagementSystem tasks = new TaskManagementSystem();

        tasks.pushTask(task1);
        tasks.pushTask(task2);
        tasks.pushTask(task3);
        tasks.pushTask(task4);
        tasks.pushTask(task5);
        tasks.displayTasks();

        System.out.println("\n\n");

        /*
        System.out.println("Firts Task !!!");
        tasks.pushTask(task1);
        tasks.pushTask(task2);
        tasks.displayTasks();
        tasks.pushTask(task3);
        tasks.pushTask(task4);
        tasks.pushTask(task5);
        tasks.displayTasks();
        */

        System.out.println("\nPOP....");

        tasks.pop(true);
        System.out.println("After POPPING");
        tasks.displayTasks();

        System.out.println("POPPED ELEMENTS");
        tasks.displayProcessedTask();


    }
}