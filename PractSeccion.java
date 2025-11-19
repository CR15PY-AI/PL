import java.util.*;
public class Main {
    public static void main(String[] args) {
//        printHello();
//        printNumbers(40);
//        sum(1,4);
        findMax(new int[]{1, 3, 4, 6, 37, 5, 4563, 524, 7, 8465, 8234, 7});
        reversedArray(new int[]{1, 3, 4, 6, 37, 5, 4563, 524, 7, 8465, 8234, 7});

    }

    public static void printHello() {
        System.out.println("Hello wrld");
    }

    public static void printNumbers(int n) {
        for (int i = 0; i < n + 1; i++) {
            System.out.println(i);
        }
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void findMax(int[] numbers) {
        int result = numbers[0];
        for (int n : numbers) {
            if (n > result) {
                result = n;
            }
        }
        System.out.println(result);
    }

    public static void reversedArray(int[] numbers) {
        int[] reversed = new int[numbers.length];
        int j = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[j];
            j--;
        }
        System.out.println(Arrays.toString(reversed));
    }
}

