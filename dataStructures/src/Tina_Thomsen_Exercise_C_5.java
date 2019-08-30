import java.util.Comparator;

public class Tina_Thomsen_Exercise_C_5 implements Comparator<String>{

    public int compare(String o1, String o2) {
        if(o1.length() > o2.length()){
            return 1;
        }
        else if(o1.length() < o2.length()){
            return -1;
        }
        else{
            return 0;
        }
    }

    public String[] sortStrings(String[] unsorted){
        int min;

        for (int i = 0; i < unsorted.length; i++){
            min = i; //set first as smallest

            for (int j = i + 1; j < unsorted.length; j++){ //find smallest
                String sMin = unsorted[min];
                String sStart = unsorted[j];

                if(compare(sMin, sStart) >= 1){
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
