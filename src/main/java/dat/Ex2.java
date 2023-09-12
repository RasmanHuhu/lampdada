package dat;

import java.util.Arrays;

public class Ex2 {

    @FunctionalInterface
    interface MyTransformingType {
        int transform(int a);
    }

    @FunctionalInterface
    interface MyValidatingType {
        boolean validate(int a);

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] result = map(a, x -> x * 4);
        System.out.println(Arrays.toString(result));

        int[] evens = filter(a,x-> x % 2 == 0);
        System.out.println("Lige tal: "+ Arrays.toString(evens));

    }

    static int[] map(int[] a, MyTransformingType op) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = op.transform(a[i]);
        }
        return result;
    }


    static int[] filter(int[] a, MyValidatingType ex) {

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (ex.validate(a[i])) {
                count++;
            }
        }

        int[] result = new int[count];

        count = 0;
        for (int i = 0; i < a.length; i++) {
            if (ex.validate(a[i])) {

                result[count] = a[i];
                count++;
            }
        }
        return result;
    }
}

