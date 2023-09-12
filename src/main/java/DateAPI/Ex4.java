package DateAPI;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ex4 {
    public static void main(String[] args) {

        List<Employee> employeeList = List.of(new Employee("Bertil", LocalDate.of(1980,2,16)),
        new Employee("Jens",LocalDate.of(2016,8,2)),
        new Employee("Ole",LocalDate.of(1945,5,22)),
        new Employee("Rasmus",LocalDate.of(1962,7,2))
        );

        Function<Employee,Integer> calculateAge = employee -> {
            LocalDate time = LocalDate.now();
            Period period = Period.between(employee.getBirthdate(),time);

            return period.getYears();
        };
        for (Employee e: employeeList) {
            System.out.println(e + " Alder: " + calculateAge.apply(e));


        }
        System.out.println("----------------");


        Function<List<Employee>,Float> calculateAverageAge = employees -> {
            float sum = 0;
            for (Employee e: employees) {
                sum += calculateAge.apply(e);
            }
            float averageAge = sum / employeeList.size();

            return averageAge;
        };
        System.out.println("Gennemsnit alderen er: " + calculateAverageAge.apply(employeeList));

        System.out.println("----------------");




    }
}