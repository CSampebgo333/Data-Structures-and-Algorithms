public class InClassActivityIII {

    public static int NumberOfNegative(int [] listInt){
        int count = 0;
        for (int i = 0; i < listInt.length; i ++){
            if (listInt[i] < 0){
                count += 1;
            }
        }
        return count;
    }


    public static int LargestDifference(int [] listInt){
        int largestDiff = listInt[0] - listInt[1];
        int previousInt = 0;
        for (int i = 0; i < listInt.length; i ++){
            int currentInt = listInt[i];
            if ((currentInt - previousInt) > largestDiff){
                largestDiff = currentInt - previousInt;
            }
            previousInt = listInt[i];
        }
        return largestDiff;
    }

    public static int  RepeatedValues(int [] listInt){
        int count = 0;
        int previousInt = listInt[0];
        for (int i = 0; i < listInt.length; i ++){
            int currentInt = listInt[i];
            if (currentInt == previousInt){
                count += 1;
            }
            previousInt = listInt[i];
        }
        return count;
    }
}
