import java.util.Arrays;

public class Tina_Thomsen_Exercise_C_1 {

    public static boolean containsChar(String s, char ch){

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ch){
                return true;
            }
        }
        return false;
    }
}
