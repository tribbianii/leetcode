package leetcode;

public class StringFirstUniqueCharacterInString {

	public int FirstUniqueCharacterInString(String s) {
		if (s==null||s.length()==0) {
			return -1;
		}
		for (int i=0;i<s.length();i++) {
			if(s.lastIndexOf(s.charAt(i))==i&&s.substring(0, i).indexOf(s.charAt(i))==-1&&s.charAt(i)!=' ') {
				return i;
			}
		}
		return -1;
	}
//method1 use lastindexof function to verify charAt(i) doesn't appear before nor after index i
	public static int firstUniqueCharacterInString(String s) {
		if (s==null||s.length()==0) {
			return -1;
		}
		int [] CharCounts = new int[26];
		//not allowed to initialize array with variable length like new int[s.length()]
		for (int i=0;i<s.length();i++) {
			CharCounts[s.charAt(i)-'a']++;
		}
		for (int j=0;j<s.length();j++) {
			if (CharCounts[s.charAt(j)-'a']==1) {
				return j;
			}
		}
		return -1;
	}
//method2 use array to store the character that occurred
//the index of character is the character itself minus 'a'
//the value of element is the occurrence of corresponding character
//method2 is faster
}
