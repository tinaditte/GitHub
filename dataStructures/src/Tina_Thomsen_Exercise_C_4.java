import java.util.Arrays;
import java.util.Objects;

public class Tina_Thomsen_Exercise_C_4 {

    public static String[] sortStrings(String[] unsorted){
        int min;
        for (int i = 0; i < unsorted.length; i++){
            min = i; //set first as smallest

            for (int j = i + 1; j < unsorted.length; j++){ //find smallest
                if(unsorted[j].compareTo(unsorted[min]) < 0){
                    min = j;
                }
            }
            if (min != i){
                swap(unsorted, min, i);
            }
        }
        return unsorted;
    }

    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}
