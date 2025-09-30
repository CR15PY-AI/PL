import java.util.Scanner;


public class HomeWork3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the attendence (0-10): ");
        int attendance = scanner.nextInt();
        System.out.print("Enter the HomeWork points (0-60): ");
        int homework = scanner.nextInt();
        System.out.print("Enter the exam points (0-30): ");
        int exam = scanner.nextInt();
        int total = attendance + homework + exam;
        if (attendance < 0 || attendance > 10) {
            System.out.println("Error");
            return;
        }
        if (homework < 0 || homework > 60) {
            System.out.println("Error");
            return;
        }
        if (exam < 0 || exam > 30) {
            System.out.println("Error");
            return;
        }
        if (total < 65 || attendance < 6 || exam < 17) {
            System.out.println("Failed");
        } else {
            System.out.println("Passed");
        }
    }
}