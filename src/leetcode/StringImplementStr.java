package leetcode;

public class StringImplementStr {

	public int ImplementStr(String haystack, String needle) {
		if (needle.length()==0||needle==null){
            return 0;
        }
        for (int i=0;i<=haystack.length()-needle.length();i++) {
			if (haystack.substring(i, i+needle.length()).equals(needle)) {
				return i;
			}
		}
		return -1;
	}
}
//return the index of the first occurrence of needle in haystack
//return -1 if needle doesn't exist in haystack
//return 0 if needle is ""

//use substring and .equal(not == operator)
//the boundary of index to traverse