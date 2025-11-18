import java.util.Arrays;

public class HomeWork9 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 6, 37, 5, 84563, 524, 7, 8465, 8234, 7};
//        int result = numbers[0];
//        for (int n : numbers) {
//            if (n>result) {
//                result = n;
//            }
//        }
//        System.out.println(result);
//####################################################
//        int[] reversed = new int[numbers.length];
//        int j = numbers.length - 1;
//        for (int i = 0; i < numbers.length; i++) {
//            reversed[i] = numbers[j];
//            j--;
//        }
//        System.out.println("Reversed array: " + Arrays.toString(reversed));
//###########################################################
        int[] numbers2 = {6,7,8,5,2,35,6,7,2352,6,57,235,6,7,9,4};
        int[] result = new int[numbers.length + numbers2.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = numbers[i];
        }
        for (int j = 0; j < numbers2.length; j++) {
            result[numbers.length+j] = numbers2[j];

        }
        System.out.println(Arrays.toString(result));
    }
}