package dat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex3 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 67, 54, 32, 18, 19};

        Predicate<Integer> thirds = x -> x % 3 == 0;

        for (int i : a) {
            if (thirds.test(i)) {
                System.out.println(i);
            }

        }
        Supplier<Employee> employeeSupplier = () -> {
            List<String> employeeList = Arrays.asList("John", "Bertil", "Konrad", "Alberte", "Jensine");

            int rnd = (int) (Math.random() * employeeList.size() - 1);
            int rndAge = (int) (Math.random() * (50 - 10) + 10); //Forsøg på at få age med i supplier

            return new Employee(employeeList.get(rnd), rndAge);
        };

        for (int i = 0; i < 4; i++) {

            System.out.println(employeeSupplier.get());
        }
        System.out.println("----------------");

        List<Employee> eList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            eList.add(employeeSupplier.get());

        }

        Consumer<List<Employee>> consumer = employees -> {
            employees.forEach(System.out::println);
        };
        consumer.accept(eList);
        System.out.println("----------------");


        Function<List<Employee>, List<String>> listOfEmployeesFunction = employees -> {
            List<String> employeeList = new ArrayList<>();
            for (Employee e : employees) {
                employeeList.add(e.getName());
            }
            return employeeList;
        };
        System.out.println(listOfEmployeesFunction.apply(eList));
        System.out.println("----------------");

        Predicate<Employee> checkGivenAgeOfEmployee = employee -> employee.getAge() >= 18;
        for (Employee e : eList) {
            if (checkGivenAgeOfEmployee.test(e)) {
                System.out.println("Personen er over 18: " + e);
            } else {
                System.out.println("Personen er ikke over 18: " + e);
            }
        }

        Consumer<List<Employee>> writeToFile = emp -> {
            try (FileWriter writer = new FileWriter("employeeList.txt")) {
                for (Employee employee : emp) {
                    writer.write("Navn: " + employee.getName() + " - Alder: " + employee.getAge() + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        writeToFile.accept(eList);
    }
}