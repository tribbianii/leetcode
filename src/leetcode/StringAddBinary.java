package leetcode;

class StringAddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int counter = 0;
            counter = i >= 0 && a.charAt(i --) == '1' ? counter + 1 : counter;
            counter = j >= 0 && b.charAt(j --) == '1' ? counter + 1 : counter;
            counter += carry;
            res.append(counter % 2 == 1 ? '1' : '0');
            carry = counter > 1 ? 1 : 0;
        }
        if (carry == 1) {
            res.append('1');
        }
        return res.reverse().toString();
    }
}