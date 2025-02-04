public class Solution {
    public static double mergeArray(int[] arry1, int[] arry2){
        int [] mergedArray = new int[arry1.length + arry2.length];
        int i1 = 0;
        int i2 = 0;
        if (arry1.length > arry2.length){
            for (int i = 0; i < arry1.length; i++){
                if (arry1[i1] < arry2[i2]){
                    mergedArray[i] = arry1[i1];
                    i1 ++;
                } else if (arry1[i1] > arry2[i2]) {
                    mergedArray[i] = arry2[i2];
                    i2 ++;
                } else {
                    mergedArray[i] = arry1[i1];
                    mergedArray[i + 1] = arry2[i2];
                    i1 ++;
                    i2 ++;
                    i ++;
                }
            }
        }
        else {
            for (int i = 0; i < arry2.length; i++){
                if (arry1[i1] < arry2[i2]){
                    mergedArray[i] = arry1[i1];
                    i1 ++;
                } else if (arry1[i1] > arry2[i2]) {
                    mergedArray[i] = arry2[i2];
                    i2 ++;
                } else {
                    mergedArray[i] = arry1[i1];
                    mergedArray[i + 1] = arry2[i2];
                    i1 ++;
                    i2 ++;
                    i ++;
                }
            }
        }
        int len = mergedArray.length;
        if (len % 2 == 0){
            int bigItem = mergedArray[len/2];
            int smallItem = mergedArray[(len/2) - 1];
            double median = (double) (bigItem + smallItem) / 2;
            return median;
        }
        else {
            double median = mergedArray[(len) / 2];
            return median;
        }
    }
}
