import java.util.Scanner;




public class main{
    public static void main(String[] args) {
        Scanner sc new Scanner(System.in);

        System.out.print("Enter the first number: ")
        double x = sc.nextDouble();

        System.out.print("Enter the op: +, -, *, / ")
        char operator = sc.next();

        System.out.print("Enter the second number: ")
        double y = sc.nextDouble();

        double result;

        if (operator.equals('+')) {
            result = x + y;
            System.out.println(result);
        } else if (operator.equals('-')) {
            result = x - y;
            System.out.println(result);
        } else if (operator.equals('*')) {
            result = x * y;
            System.out.println(result);
        } else if (operator.equals('/')) {
            if (y == 0) {
                System.out.println("Делить на ноль нельзя!!!!!!!!!!!!!!!!!!!!!!!");
            } else {
                result = a/b;
                System.out.println(result);
            }

        }
    }
}
