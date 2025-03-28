import java.util.Arrays;
import java.util.List;

public class Main {
    public static int[] BubbleSort(int[] array){
        boolean swapped = true;
        while(swapped){
            swapped = false;
            for (int i = 0; i < array.length - 2; i++){
                if (array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return array;
    }

    public static void main(String[] args){
        System.out.println("Let's gooo!");

        int [] ages = {10, 5, 7, 8, 9, 21};
        int [] bubbleSortedAge = BubbleSort(ages);
        System.out.println(Arrays.toString(bubbleSortedAge));
    }
}