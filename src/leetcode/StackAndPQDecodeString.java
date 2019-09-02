package leetcode;

public class StackAndPQDecodeString{
    private int i = 0;
    public String decodeString(String s) {
        StringBuilder string = new StringBuilder();
        String num = "";
        for (; i < s.length(); i++) {
            if (s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i))) {
                string.append(s.charAt(i));
            //determine if char is digit
            } else if (Character.isDigit(s.charAt(i))) {
                num += s.charAt(i);
            } else if (s.charAt(i) == '[') {
                i++;
                //recursion
                String next = decodeString(s);
                //both Integer.valueOf() and Integer.parseInt() work
                for (int n = Integer.valueOf(num); n > 0; n--) {
                    string.append(next);
                }
                num = "";
            } else if (s.charAt(i) == ']') {
                return string.toString();
            }
        }
        return string.toString();
    }
}