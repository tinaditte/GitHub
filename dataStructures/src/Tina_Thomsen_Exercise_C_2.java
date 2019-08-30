public class Tina_Thomsen_Exercise_C_2 {

    public static boolean findString(String[] array, String str){
        for(String s : array){
            if(s == str){
                return true;
            }
        }
        return false;
    }
}
