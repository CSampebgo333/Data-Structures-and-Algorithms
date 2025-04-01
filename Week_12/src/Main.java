public class Main{
    public static void main(String [] args) throws Exception {
        System.out.println("\"In class Assignment II\"\n");

        TaskNode task1 = new TaskNode("DSA Assignment", true);
        TaskNode task2 = new TaskNode("Intro to AI Project", true);
        TaskNode task3 = new TaskNode("Bring my cloths to the laundry");
        TaskNode task4 = new TaskNode("Reflect on Linear Algebra Project");
        TaskNode task5 = new TaskNode("Check Learners progress", true);

        ManagementSystem tasks = new ManagementSystem();
        tasks.push(task1);
        tasks.push(task2);
        tasks.push(task3);
        tasks.push(task4);
        tasks.push(task5);
        tasks.displayAll();
        //System.out.println("\n*Reached*\n");


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
        tasks.pop(true);
        //System.out.println("After POPPING");
        //tasks.displayAll();

        System.out.println("\nPOPPED ELEMENTS\n");
        tasks.displayProcessedTask();
        System.out.println("\nPOPPED ELEMENTS\n");

        tasks.displayAll();
        //System.out.println("Total Tasks Size: " + tasks.getTotalTaskSize());
    }
}
