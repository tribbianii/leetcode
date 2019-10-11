package leetcode;

public class DPEditDistance{
    //recursion solution
    public int editDistance (String one, String two) {
        if (one.length() * two.length() == 0) {
            return one.length() == 0 ? two.length() : one.length();
        }
        if (one.charAt(0) == two.charAt(0)) {
            return editDistance(one.substring(1), two.substring(1));
        }
        int replace = 1 + editDistance(one.substring(1), two.substring(1));
        int delete = 1 + editDistance(one.substring(1), two);
        int insert = 1 + editDistance(one, two.substring(1));
        return Math.min(replace, Math.min(delete, insert));
    }
    //DP solution
    public int minDistance(String word1, String word2) {
        if (word1==null||word2==null){
            return 0;
        }
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1==0||len2==0){
            return len1+len2;
            //simply insert same number of characters of word to '' to match word
        }
        int[][] dis = new int[len1+1][len2+1];
        //dis[i][j] means the eidt distance from word1[0->i] to word2[0->j]
        for (int i=0;i<=len1;i++){
            for (int j=0;j<=len2;j++){
                if (i*j==0){
                    dis[i][j] = i+j;
                    //from '' to word[0->i/j] need i/j steps of inserting
                    continue;
                }
                else if (word1.charAt(i)==word2.charAt(j)){
                    dis[i][j] = dis[i-1][j-1];
                    //'abc'->'adc', need the same steps as from 'ab'->'ad' does
                    //so ds[i][j] = ds[i-1][j-1] when word1[i-1] = word2[j-1]
                    continue;
                }
                else{
                    dis[i][j] = Math.min(Math.min(dis[i-1][j],dis[i][j-1]),dis[i-1][j-1]) + 1;
                    //'ab'->'abc', need one step which is insert
                    //so ds[i][j] can be ds[i-1][j] + 1
    
                    //'abc'->'ab', need one step whihc is delete
                    //so ds[i][j] can be ds[i][j-1] + 1

                    //choose the minimum one from 3 candidates and plus 1
                }
            }
        }
        return dis[len1][len2];
    }
    
    
    
}
