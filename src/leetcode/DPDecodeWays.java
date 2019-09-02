package leetcode;

public class DPDecodeWays{
    public int numDecodings(String s){
        if(s.length()==0||s==null){
            return 0;
        }
        if(s.charAt(0)-'0'==0){
            return 0;
        }
        if (s.length()==1&&s.charAt(0)-'0'!=0){
            return 1;
        }
        int[] res = new int[s.length()+1];
        res[0] = 1;
        res[1] = 1;
        //set res[0] = 1 to ensure res[2] = res[1] + res[0]
        //eg.input:'12' / output:2 ('A'+'B','L')
        for (int i=2;i<=s.length();i++){
            if(s.charAt(i-1)-'0'==0){
                if (s.charAt(i-2)-'0'>2||s.charAt(i-2)-'0'==0){
                    continue;
                }
                else{
                    res[i] = res[i-2];
                }
            }
            else{
                if (s.charAt(i-2)-'0'==0||Integer.valueOf(s.substring(i-2,i))>26){
                    res[i] = res[i-1];
                }
                else{
                    res[i] = res[i-1]+res[i-2];
                }
            }
        }
        return res[s.length()];
    }
    //method 1 use array with length of s.length+1 to store intermediate results
    //relatively  slow and space complexity is O(n)
    public int NumDecodings(String s){
        if(s.length()==0||s==null){
            return 0;
        }
        if(s.charAt(0)-'0'==0){
            return 0;
        }
        if (s.length()==1&&s.charAt(0)-'0'!=0){
            return 1;
        }
        int pre = 1;
        int cur = 1;
        for (int i=2;i<=s.length();i++){
            if(s.charAt(i-1)-'0'==0){
                if (s.charAt(i-2)-'0'>2||s.charAt(i-2)-'0'==0){
                    pre = cur;
                    cur = 0;
                }
                else{
                    int temp1 = cur;
                    cur = pre;
                    pre = temp1;
                }
            }
            else{
                if (s.charAt(i-2)-'0'==0||Integer.valueOf(s.substring(i-2,i))>26){
                    pre = cur;
                }
                else{
                    int temp2 = cur;
                    cur = cur + pre;
                    pre = temp2;
                }   
            }
        }
        return cur;
    }
    //because in method 1 we only use res[i-2] and res[i-1] to track results
    //so we can only update two variable in for loop instead of having array
    //faster and space complexity only O(1) 
}
