import java.util.ArrayList;

public class Employee {
    private String name;
    private ArrayList<Integer> workHours;
    private int totalWorkHours;

    public Employee(String name, ArrayList<Integer> workHours)
    {
        this.name = name;
        this.workHours = workHours;
    }

    public ArrayList<Integer> getWorkHours()
    {
        return this.workHours;
    }

    public String getName()
    {
        return this.name;
    }
}
