package leetcode;

public class MathCompareVersionNumber {

	public int CompareVersionNumber(String version1, String version2) {
		String[] levels1 = version1.split("\\.");
	    String[] levels2 = version2.split("\\.");
	    
	    int length = Math.max(levels1.length, levels2.length);
	    for (int i=0; i<length; i++) {
	    	Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
	    	Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
	    	if (v1>v2) {
	    		return 1;
	    	}
	    	if (v1<v2) {
	    		return -1;
	    	}
	    	continue;
	    }
	    return 0;
	}
//split string with split("\\.") function into string array
//Integer.parseInt() to convert string to int
//replace empty with 0
}
