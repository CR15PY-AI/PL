import java.util.*;
public class PractTask {
    public static void main(String[] args) {
//        System.out.println(task1("Java is cool"));
//        System.out.println(task2("Java is cool"));
//        System.out.println(task3("Java is cool"));
//        System.out.println(task4());
//        System.out.println(task5("Java is cool"));
//        System.out.println(task6("Java is cool"));
//        System.out.println(task7("Java is cool"));
//        System.out.println(task8("Java is cool"));
//        System.out.println(task9("Java is cool"));
//        System.out.println(task10("Java is cool"));
//        System.out.println(task11("Java is cool"));
//        System.out.println(task12("Java is cool"));
//        System.out.println(task13("Java is cool"));
//        System.out.println(task15("Java is cool"));
//        System.out.println(task16("Java is cool"));
//        System.out.println(task18("Java is cool"));
        System.out.println(task20("Java is cool"));
    }

    public static int task1(String s) {
        return s.length();
    }

    public static String task2(String s) {
        return s.toUpperCase() + " " + s.toLowerCase();
    }

    public static String task3(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите индекс: ");
        int i = sc.nextInt();
        return String.valueOf(s.charAt(i));

    }

    public static String task4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();
        String res4;
        if (s1.equals(s2)) {
            res4 = "Equal";
        } else {
            res4 = "NON equal";
        }
        return res4;
    }

    public static String task5(String s) {
        String res5 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            res5 += s.charAt(i);
        }
        return res5;
    }

    public static int task6(String s) {
        int count = 0;
        String vowels = "aeiouAEIOU";

        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static String task7(String s) {
        String res7 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            res7 += s.charAt(i);
        }
        if (s.equals(res7)) {
            return "Polindrome";
        } else {
            return "Not polindrome";
        }
    }

    public static String task8(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String to check: ");
        String x = sc.nextLine();
        if (s.contains(x)) {
            return "Found";
        } else {
            return "NOT Found";
        }
    }

    public static String task9(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String to change: ");
        String y = sc.nextLine();
        System.out.print("Enter new String: ");
        String z = sc.nextLine();
        return s.replace(y, z);
    }

    public static String task10(String s) {
        int count = 0;
        char ch = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                count++;
            }
        }
        return count + 1 + " words";
    }


    public static String task11(String s) {
        String res11 = s.replace(" ", "");
        return res11;
    }

    public static String task12(String s) {
        int[] arr = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c]++;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result.append((char) i).append(": ").append(arr[i]).append("\n");
            }
        }

        return result.toString();
    }


    public static String task13(String s) {
        StringBuilder res13 = new StringBuilder();
        for (char i : s.toCharArray()) {
            if (Character.isUpperCase(i)) {
                res13.append(Character.toLowerCase(i));
            } else if (Character.isLowerCase(i)) {
                res13.append(Character.toUpperCase(i));
            } else {
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
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                letters++;
            } else if (Character.isDigit(ch)) {
                digits++;
            }
        }
        return Arrays.toString(new int[]{letters, digits});
    }

    public static String task18() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String word1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String word2 = sc.nextLine();

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        if (word1.length() != word2.length()) {
            return "NOT Anagram";
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        if (Arrays.equals(chars1, chars2)) {
            return "Anagram";
        } else {
            return "Not Anagram";
        }
    }
    
    public static String task19(String s){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите слово, которое нужно удалить: ");
        String word = sc.nextLine();
        String res19 = s.replace(word, "");
        return res19;
    }
    public static String task20(String s) {


        StringBuilder res20 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char newChar = (char)(c + 1);
            res20.append(newChar);
        }

        return res20.toString();
    }

}


