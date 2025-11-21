import java.util.*;
public class PractTask {
    public static void main(String[] args) {
//        System.out.println(task11("Java is cool"));
//        System.out.println(task12("Java is cool"));
//        System.out.println(task13("Java is cool"));
//        System.out.println(task15("Java is cool"));
        System.out.println(task16("Java is cool"));
    }
    public static String task11(String s) {
        String res11 = s.replace(" ", "");
        return res11;
    }
    public static int task12(String s) {
        int res12 = s.length();
        return res12;
    }
    public static String task13(String s) {
        StringBuilder res13 = new StringBuilder();
        for (char i : s.toCharArray()) {
            if (Character.isUpperCase(i)) {
                res13.append(Character.toLowerCase(i));
            }else if (Character.isLowerCase(i)) {
                res13.append(Character.toUpperCase(i));
            }else {
                res13.append(i);
            }
        }
        return res13.toString();
    }
    public static String task15(String s) {
        StringBuilder res15 = new StringBuilder();
        for (char i : s.toCharArray()) {
            if (res15.indexOf(String.valueOf(i)) == -1) {
                res15.append(i);
            }
        }
        return res15.toString();
    }
    public static List<Character> task16(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }

        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int maxCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
            }
        }

        List<Character> result = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount) {
                result.add((char) i);
            }
        }

        return result;
    }
    public static String task17(String s) {
        int letters = 0;
        int digits = 0;
        for (int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (Character.isLetter(ch)){
                letters++;
            } else if (Character.isDigit(ch)){
                digits++;
            }
        }
        return Arrays.toString(new int[]{letters, digits});
    }

}



