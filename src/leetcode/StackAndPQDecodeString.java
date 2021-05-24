package leetcode;

public class StackAndPQDecodeString{
    private int index = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder num = new StringBuilder();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c != '[' && c != ']' && !Character.isDigit(c)) {
                res.append(c);
            } else if (Character.isDigit(c)) {
                num.append(c);
            } else if (c == '[') {
                index ++;
                String next = decodeString(s);
                for (int n = Integer.parseInt(new String(num)); n > 0; n--) {
                    res.append(next);
                }
                num = new StringBuilder();
            } else if (c == ']') {
                return res.toString();
            }
            index ++;
        }
        return res.toString();
    }
}