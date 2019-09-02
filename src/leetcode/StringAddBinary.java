package leetcode;


class StringAddBinary {
    public String addBinary(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;

        char[] copy = len1 > len2 ? arr1.clone() : arr2.clone();
        int lo = copy.length;
        int sh = Math.min(len1, len2);
        
        int carry = 0;
        
        for (int i=1; i<=lo; i++) {
            int bit = i <= sh ? (arr1[len1-i]-'0') + (arr2[len2-i]-'0') + carry : (copy[lo-i]-'0') + carry;
            copy[lo-i] = (char)(bit%2+'0');
            carry = bit < 2 ? 0 : 1;
        }
        return carry == 1 ? new StringBuilder().append('1').append(String.valueOf(copy)).toString() : String.valueOf(copy);
    }
    //most liked solution on leetcode
    //less space complexity
    public String AddBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}