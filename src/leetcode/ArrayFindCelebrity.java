package leetcode;

public class ArrayFindCelebrity {

	public boolean knows(int p1, int p2) {
		if (p2==p1+1) {
			return true;
		}
		return false;
	}
	
	public int FindCelebrity(int n) {
		if (n<=1) {
			return -1;
		}
		int k=0;
		for (int j=1;j<n;j++) {
			if (knows(k,j)) {
				k=j;
			}
		}
		for (int m=0;m<n;m++) {
			if (m!=k &&(!knows(m,k)||knows(k,m))) {
				return -1;
			}
		}
		return k;
	}

}
//find the potentially existing one celebrity who are known by all others and doesn't know any other
//given helper function boolean knows(a,b) if a knows b than true or false

//every call of knows(a,b) gives us that a is not celebrity if true, or neither does b if false
//the first traversal gives one potential candidate, and second traversal to verify