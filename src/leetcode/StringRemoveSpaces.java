package leetcode;

public class StringRemoveSpaces{
    //remove leading and trailing spaces and keep one space betwwen words
    public String removeSpaces(String input){
        char[] arr = input.toCharArray();
        int slow = 0;
        int fast = 0;
        int words_count = 0;
        while (fast < arr.length) {
            while (fast < arr.length && arr[fast] == ' ') {
                fast ++;
            }
            if (words_count > 0) {
                arr[slow ++] = ' ';
            }
            while (fast < arr.length && arr[fast] != ' ') {
                arr[slow ++] = arr[fast ++];
            }
        }
        return String.copyValueOf(arr, 0, slow);
    }
}