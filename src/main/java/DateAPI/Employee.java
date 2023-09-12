package DateAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
public class Employee {
    private String name;
   // private int age;
    private LocalDate birthdate;
}
