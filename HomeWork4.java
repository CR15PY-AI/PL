import java.util.Scanner;

public class HomeWork4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Odd or Even");
            System.out.println("2. Grade Calculator");
            System.out.println("3. Temperature Converter");
            System.out.println("4. Leap Year Checker");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    oddOrEven(sc);
                    break;
                case 2:
                    gradeCalculator(sc);
                    break;
                case 3:
                    temperatureConverter(sc);
                    break;
                case 4:
                    leapYearChecker(sc);
                    break;
            }
        }
    }

    // 1. Odd or Even
    public static void oddOrEven(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }
    }

    // 2. Grade Calculator
    public static void gradeCalculator(Scanner sc) {
        System.out.print("Enter score (0-100): ");
        int score = sc.nextInt();
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }

    // 3. Temperature Converter
    public static void temperatureConverter(Scanner sc) {
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println("In Fahrenheit: " + fahrenheit);

        if (fahrenheit > 85) {
            System.out.println("It's hot!");
        } else if (fahrenheit < 50) {
            System.out.println("It's cold!");
        } else {
            System.out.println("It's comfortable.");
        }
    }

    // 4. Leap Year Checker
    public static void leapYearChecker(Scanner sc) {
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
}
