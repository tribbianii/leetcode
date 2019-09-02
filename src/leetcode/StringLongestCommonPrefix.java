package leetcode;

public class StringLongestCommonPrefix {

	public String LongestCommonPrefix(String[] strs) {
		if (strs.length==0||strs==null) {
			return "";
		}
		int minlen = Integer.MAX_VALUE;
		for (String str : strs) {
			minlen = Math.min(minlen, str.length());
		}
		for (int i=0;i<minlen;i++) {	
			for (String str : strs) {
				if (strs[0].toCharArray()[i]!=str.toCharArray()[i]){
					return str.substring(0, i);
				}
			}
		}
		return strs[0].substring(0, minlen);
	}
}
