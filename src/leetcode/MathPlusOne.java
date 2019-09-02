package leetcode;

public class MathPlusOne {

	public int [] PlusOne(int[] num) {
		int[] res = new int[num.length+1];
		for (int i=num.length-1;i>=0;i--) {
			if (num[i]!=9) {
				num[i]++;
				return num;
			}
			else {
				if (i!=0) {
					num[i]=0;
				}
				else {
					res[0] = 1;
				}
			}
		}
		return res;
	}
//never convert array to int number! can't handle type range overflow
}
