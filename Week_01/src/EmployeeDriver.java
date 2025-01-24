import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeDriver {
    public enum WorkDays {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
    }
    public static void main(String[] args)
    {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanEntry = new Scanner(System.in);
        System.out.print("Number employees: ");
        int numEmp = scanEntry.nextInt();

        while(numEmp >= 1)
        {
            System.out.print("\nName: ");
            String employeeName = scanEntry.next();
            ArrayList<Integer> employeeWorkHours = new ArrayList<>();
            int totalWorkHours = 0;
            int daylyHour = 0;

            for (WorkDays day : WorkDays.values())
            {
                System.out.print(day + ": ");
                daylyHour = scanEntry.nextInt();
                employeeWorkHours.add(daylyHour);
                totalWorkHours += daylyHour;
            }

            Employee newEmployee = new Employee(employeeName, totalWorkHours, employeeWorkHours);
            employees.add(newEmployee);
            numEmp -= 1;
        }

        Collections.sort(employees);

        for (int i = 0; i < employees.size(); i++)
        {
            System.out.print(employees.get(i).toString());
            System.out.println(employees.get(i).displayDataBase());
        }
    }
}
