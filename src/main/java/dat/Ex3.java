package dat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
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

            return new Employee(employeeList.get(rnd));
        };

        for (int i = 0; i < 4; i++) {

            System.out.println(employeeSupplier.get());
        }


        List<Employee> eList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            eList.add(employeeSupplier.get());

        }

        Consumer<List<Employee>> consumer = employees -> {
            employees.forEach(System.out::println);
        };
    }
}
