package dat;

import java.util.Arrays;

public class Ex1 {
    @FunctionalInterface
    interface ArithmeticOperation {
        float perform(float a, float b);
    }

    public static void main(String[] args) {
        System.out.println("Hello functinoal");


        ArithmeticOperation addition = (a, b) -> a + b;
        ArithmeticOperation subtraction = (a, b) -> a - b;
        ArithmeticOperation multiplication = (a, b) -> a * b;
        ArithmeticOperation division = (a, b) -> a / b;
        ArithmeticOperation modulus = (a, b) -> a % b;
        ArithmeticOperation power = (a, b) -> (int) a ^ (int) b; // Virker ikke med float

        System.out.println("Add 5 + 6: " + addition.perform(5, 6));
        System.out.println("Subtract 6-5: " + subtraction.perform(6, 5));
        System.out.println("Multiply 6 * 5: " + multiplication.perform(6, 5));
        System.out.println("Divide 10/5: " + division.perform(10, 5));
        System.out.println("Modulus 6%5: " + modulus.perform(6, 5));
        System.out.println("Power 6^5: " + power.perform(6, 5));

        System.out.println(operate(22, 8, addition));
        System.out.println(operate(22, 8, subtraction));

        float[] a = {1, 2, 3, 4, 5};
        float[] b = {6, 7, 8, 9, 10};

        showArray(operate(a, b, addition));
        showArray(operate(a, b, subtraction));
    }

    private static float add(float x, float y) {
        return x + y;
    }

    static float operate(float a, float b, ArithmeticOperation op) {
        return op.perform(a, b);
    }

    static float[] operate(float[] a, float[] b, ArithmeticOperation op) {
        float[] result = new float[a.length];
        if (a.length != b.length) {
            System.out.println("Uens antal tal i arrays");
        } else {
            for (int i = 0; i < a.length; i++) {
                result[i] = op.perform(a[i], b[i]);
            }
        }
        return result;
    }

    static void showArray(float[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}


