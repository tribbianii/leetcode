package leetcode;

public class MathReverseInteger {

	public int ReverseInteger(int num) {
		if (num==0) {
			return 0;
		}
		long res = 0;
		while (num!=0) {
			res  = res*10 + num%10;
			num = num/10;
		}
		return res>=Integer.MIN_VALUE&&res<=Integer.MAX_VALUE?(int)res:0;
	}
//the reversed num which is res may overflow the range of int [-2^31,2^31-1], so initialized to be long 
//the fastest method in leetcode!
}
