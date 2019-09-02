package leetcode;

public class StringRemoveSpaces{
    //remove leading and trailing spaces and keep one space betwwen words
    public String removeSpaces(String input){
        char[] arr = input.toCharArray();
        String res = "";
        //find the first non-space char
        int i = 0;
        while (i < arr.length){
            if (arr[i]!=' '){
                break;
            }
            i++;
        }
        if (i==arr.length){
            return res;
        }
        //start traversal
        int slow = i+1;
        int fast = slow;
        while (fast < arr.length){
            //keep only one space between words
            if (arr[fast]==' ' && arr[fast-1]==' '){
                fast++;
                continue;
            }
            else {
                arr[slow++] = arr[fast++];
            }
        }
        //remove trailing space
        if (arr[slow-1]==' '){
            slow--;
        }
        while (i < slow && i < arr.length){
            res += arr[i++];
        }
        return res;
    }
}