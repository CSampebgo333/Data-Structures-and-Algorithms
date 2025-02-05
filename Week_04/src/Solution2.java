public class Solution2 {
    public static boolean areAlmostEqual(String str1, String str2){
        StringBuilder orderedString = new StringBuilder();
        for (int i = 0; i < str1.length(); i++){
            for (int j = 0; j < str2.length(); j++){
                if (str1.charAt(i) == str2.charAt(j)){
                    orderedString.append(str1.charAt(i));
                }
                else {
                    continue;
                }
            }
        }

        if (str1.equals(orderedString.toString())){
            return true;
        }
        return false;
    }
}
