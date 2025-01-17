import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InClassLabPractice {
    public static void main(String[] args) {
        System.out.println("Hello and Welcome!");

        // Initializations:
        Map<String, ArrayList<Integer>> employees = new HashMap();
        Scanner scanEmployee = new Scanner(System.in);
        enum WorkDays{
            MONDAY, THUESDAY, WEDNESDAY, THURSDAY, FRIDAY
        }

        System.out.print("How many employees? ");
        int numberEmployees = scanEmployee.nextInt();
        while (!(numberEmployees < 1))
        {
            System.out.print("\nEmployee Name: ");
            String empName = scanEmployee.next();

            ArrayList<Integer> empWorkHours = new ArrayList<>();
            System.out.println("<-- Working Hours --> ");
            for (WorkDays day : WorkDays.values()){
                System.out.print(day + " : ");
                empWorkHours.add(scanEmployee.nextInt());
            }

            employees.put(empName, empWorkHours);
            numberEmployees -= 1;
        }

        for (Map.Entry<String, ArrayList<Integer>> employee : employees.entrySet()){

            String name = employee.getKey();
            ArrayList<Integer> workHours = employee.getValue();
            int totalWorkHoursPerEmployee = 0;
            for (int i = 0; i < workHours.size(); i++){
                totalWorkHoursPerEmployee += workHours.get(i);
            }

            System.out.println(name + " works for " + totalWorkHoursPerEmployee + " hours.");
        }
    }
}