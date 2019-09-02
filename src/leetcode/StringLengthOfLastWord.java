package leetcode;

public class StringLengthOfLastWord {

	public int LengthOfLastWord(String s) {
		if (s.length()==0||s==null) {
			return 0;
		}
		for (int i=s.length()-1;i>=0;i--) {
			if (s.charAt(i)!=' ') {
				for (int j=i-1;j>=-1;j--) {
					if (j<0 || s.charAt(j)==' ') {
						return i-j;
					}
				}
			}
		}
		return 0;
	}
//method1 using the difference of the last index and the previous index of ' '
	public int lengthOfLastWord(String s) {
		return s.trim().length()-1-s.trim().lastIndexOf(' ');
	}
//method2 using trim function to delete the ' ' on the head and rear of string if existing
//using lastindexof function to find the index of last ' '
}
