public class AlgorithmsDesign {
    /*
    .............Description..........
     */
    public static String convert(String str, int numRows){
        int scale = (numRows * 2) - 2;
        int i;
        StringBuilder firstString = new StringBuilder();

        for (i = 0; i < str.length(); i++){
            firstString.append(str.charAt(i));
            String tempString = " ";
            for (int j = 0; j < scale; j++){
                firstString.append(tempString);
            }
        }

        StringBuilder newString = new StringBuilder();
        int count = 0;
        for (i = 0; i < firstString.length(); i++){
            if (firstString.charAt(i) == " ")
                count += 1;
            else {
                count += 0;
            }
            if (count == numRows * scale){
                newString.charAt(i) = firstString.charAt(i);
            }
            else {
                continue;
            }
        }
        return firstString.toString();
    }
}
