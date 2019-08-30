
public class Tina_Thomsen_Exercise_C_3 {
    public static int[] sortInts(int[] unsorted){

        for (int i = 0; i < unsorted.length - 1; i++){
            //find index of smallest element
            int min = i;

            for (int j = i + 1; j < unsorted.length; j++){
                if(unsorted[j] < unsorted[min]){
                    min = j;
                }
            }
            swap(unsorted, i, min);

        }

        return unsorted;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
