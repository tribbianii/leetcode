package leetcode;

public class DPInterleavingString{
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1==null||s2==null||s3==null){
              return false;
            }
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
  
        if(len1+len2!=len3){
            return false;
            //if true then s1 and s2 must be fully used
        }
        boolean[][] res = new boolean[len1+1][len2+1];
        //the matrix means the length of s1 and s2 being used, not index, which equals to matrix-1
        //res[m][n] means if s3.substring[0,m+n-1] can be formed by interleaving of s1.substring[0,m-1] and s2.substring[0,n-1]
        res[0][0]=true;
        for (int i=1;i<=len3;i++){
          for (int j=0;j<=len1&&j<=i;j++){
              if (i-j>len2){
                  continue;
                }
              if ((i-j>0&&res[j][i-j-1]&&s2.charAt(i-j-1)==s3.charAt(i-1)) || (j>0&&res[j-1][i-j]&&s1.charAt(j-1)==s3.charAt(i-1))){
                  res[j][i-j]=true;
                //add s2.charat(i-j-1) and res[j][i-j-1] already true
                //OR add s1.charat(j-1) and res[j-1][i-j] already true
                }    
            }
        }
        return res[len1][len2];
    }
}