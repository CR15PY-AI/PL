import java.util.Scanner;

public class HomeWork5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("1. Print even numbers from 1 to N (3 loops)");
        System.out.println("2. Print odd numbers from 1 to N (3 loops)");
        System.out.println("3. FizzBuzz");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                printEven(sc);
                break;
            case 2:
                printOdd(sc);
                break;
            case 3:
                fizzBuzz(sc);
                break;
        }

    }

    // 1. Even numbers (three loops)
    public static void printEven(Scanner sc) {
        System.out.print("Enter N: ");
        int N = sc.nextInt();

        System.out.println("for loop");
        for (int i = 2; i <= N; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

//  while loop
//        int i = 2;
//        while (i <= N) {
//            System.out.print(i + " ");
//            i += 2;
//        }
//        System.out.println();

//  do-while loop
//        int j = 2;
//        if (N >= 2) {
//            do {
//                System.out.print(j + " ");
//                j += 2;
//            } while (j <= N);
//        }
//        System.out.println();
    }

    public static void printOdd(Scanner sc) {
        System.out.print("Enter N: ");
        int N = sc.nextInt();

        System.out.println("for loop");
        for (int i = 1; i <= N; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

//        while loop
//        int i = 1;
//        while (i <= N) {
//            System.out.print(i + " ");
//            i += 2;
//        }
//        System.out.println();

//        do-while loop
//        int j = 1;
//        if (N >= 1) {
//            do {
//                System.out.print(j + " ");
//                j += 2;
//            } while (j <= N);
//        }
//        System.out.println();
    }

    public static void fizzBuzz(Scanner sc) {
        while (true) {
            System.out.print("Enter i: ");
            int i = sc.nextInt();
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println("незнаю");
            }
        }
    }
}