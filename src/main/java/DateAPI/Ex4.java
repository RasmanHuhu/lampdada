package DateAPI;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ex4 {
    public static void main(String[] args) {

        List<Employee> employeeList = List.of(new Employee("Bertil", LocalDate.of(1980, 2, 16)),
                new Employee("Jens", LocalDate.of(2016, 9, 2)),
                new Employee("Ole", LocalDate.of(1945, 5, 22)),
                new Employee("Rasmus", LocalDate.of(1962, 7, 2))
        );

        Function<Employee, Integer> calculateAge = employee -> {
            LocalDate time = LocalDate.now();
            Period period = Period.between(employee.getBirthdate(), time);

            return period.getYears();
        };
        for (Employee e : employeeList) {
            System.out.println(e + " Alder: " + calculateAge.apply(e));


        }
        System.out.println("----------------");


        Function<List<Employee>, Float> calculateAverageAge = employees -> {
            float sum = 0;
            for (Employee e : employees) {
                sum += calculateAge.apply(e);
            }
            float averageAge = sum / employeeList.size();

            return averageAge;
        };
        System.out.println("Gennemsnit alderen er: " + calculateAverageAge.apply(employeeList));

        System.out.println("----------------");


// 3. Filter and display employees who have birthdays in a specific month.
        // Virker halvt.

        int filterMonth = 2;
        Consumer<List<Employee>> filterMonths = employee -> {
            for (Employee e : employee) {
                if (e.getBirthdate().getMonthValue() == filterMonth) {
                    System.out.println(e.getName() + ", har alle fødselsdag i måned: " + filterMonth);
                }
            }
        };
        filterMonths.accept(employeeList);

        System.out.println("----------------");


        // Group employees by birth month and display the count of employees in each group.

        Function<List<Employee>, List<Employee>> groupEmployees = employees -> {
           List<Employee> groupByBirthMonth = new ArrayList<>();
            for(Employee e: employees){
                if (e.getBirthdate().getMonthValue() == filterMonth){
                    groupByBirthMonth.add(e);
                }
            }


            return groupByBirthMonth;
        };
        System.out.println("Employees i måneden: " + filterMonth + " - Antal: " + groupEmployees.apply(employeeList).size());
        System.out.println("----------------");


// List all employees who has a birthday in the current month.

        Function<List<Employee>, List<Employee>> groupEmployeesByCurrentMonth = employees -> {
            List<Employee> groupByBirthMonth = new ArrayList<>();
            for(Employee e: employees){
                if (e.getBirthdate().getMonthValue() == LocalDate.now().getMonthValue()){
                    groupByBirthMonth.add(e);
                }
            }


            return groupByBirthMonth;
        };
        System.out.println("Employees i denne måned: " + groupEmployeesByCurrentMonth.apply(employeeList));
        System.out.println("----------------");
        

    }
}