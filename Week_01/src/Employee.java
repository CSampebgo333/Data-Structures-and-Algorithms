import java.util.ArrayList;

public class Employee {
    private String name;
    private ArrayList<Integer> workHours;
    private int totalWorkHours;

    public Employee(String name, int totalWorkHours, ArrayList<Integer> workHours)
    {
        this.name = name;
        this.totalWorkHours = totalWorkHours;
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

    public void computeTotalWorkHours(ArrayList<Integer> workHours)
    {
        for(int i = 0; i < workHours.size(); i++)
        {
            this.totalWorkHours += workHours.get(i);
        }
    }

    @Override
    public String toString()
    {
        return this.name + " " + this.totalWorkHours + " hours\n";
    }
}
