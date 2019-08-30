/**
 * Created by tinab on 12-Apr-17.
 */
public class test {
    public static void main(String[] args) {
        String[] array = new String[]{"feelee"};
        System.out.println(J("feelee"));
    }

    public static void loop(){
       for (int i = 0; i <= 99;){          //sker på hver linjen
            for (int j = 0; j < 5; j++){   //sker hvor mange gange på hver linje
                    System.out.print(i + " ");
                    i++;
            }
            System.out.println();
       }

        System.out.print("100" + " 101" + " 102" + " 103" + " 104");
    }

    public static char C(String text) {

        return text.charAt(0);
    }

    public static boolean D(String text) {
        if (text == "yes") {
            return true;
        } else
            return false;
    }

    public static char E(String text) {

        return text.charAt(text.length() - 1);
    }

    public static char F(String text, int i) {
        return text.charAt(i);
    }

    public static String G(String s1, String s2) {
        String s3 = s1 + s2;

        return s3;
    }

    public static boolean I(String text, char c) {
        if (c == text.charAt(0)) {
            return true;
        } else
            return false;
    }

    public static String J(String text) {

        if (text.length() < 2) {
            return text;
        } else {
            String s1 = Character.toString(text.charAt(0));
            String s2 = Character.toString(text.charAt(text.length() - 1));
            String text2 = s2 + s1;

            return text2;
        }

    }

    public static int numberOfLetters(String s, char c) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                j++;
            }
        }
        return j;
    }

    public static int sumOfAllNumbers(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public static String theLongestWord(String[] array) {
        int maxLength = 0;
        String theLongest = null;
        for (String s : array) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                theLongest = s;
            }
        }
        return theLongest;
    }

    public static String mostLettersInWord(String[] array, char ch) {
        int countLetter = 0;
        String mostOcc = null;
        for (String s : array) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) {
                    countLetter++;
                    mostOcc = s;
                }
            }

        }
        return mostOcc;
    }
    /**The goal of this exercise is to practice writing your own class and object instantiation.
     Inside the class Test, there must be a public method getEntry and it shall receive nothing, but answer with a Entry object.

     You must create the Entry class inside the second editor window, and it must be public.
     The Entry class must have a field that holds numbers and have the name 'number' and it must be public too.*/

    public Entry getEntry(){
        Entry ent = new Entry();
        ent.number = 1;

        return ent;
    }


}