package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BFSDFSExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        char[] numArr = num.toCharArray();
        //the longest expression will combine n digits with (n-1) operators
        char[] expres = new char[num.length() * 2];
        dfs(numArr, expres, res, 0, 0, 0, 0, target);
        return res;
    }

    private void dfs(char[] numArr, char[] expres, List<String> res, int arrIdx, int expLen, long prevNum, long sum, int target) {
        if (arrIdx == numArr.length && sum == target) {
            res.add(new String(expres, 0, expLen));
            return;
        }
        long num = 0;
        int numGrow_Idx = arrIdx;
        int operator_Idx = expLen;
        //no operator in the begining of expression
        int digit_Idx = numGrow_Idx == 0 ? operator_Idx : operator_Idx + 1;
        while (numGrow_Idx < numArr.length) {
            //in case we grew a invalid num which is '0x'
            if (numArr[arrIdx] == '0' && numGrow_Idx > arrIdx) {
                break;
            }
            num = num * 10 + (numArr[numGrow_Idx] - '0');
            //in case we grew a overflow num
            if (num > Integer.MAX_VALUE) {
                break;
            }
            //put char from numArr into expression
            expres[digit_Idx ++] = numArr[numGrow_Idx ++];
            //if we started from index 0
            if (arrIdx == 0) {
                dfs(numArr, expres, res, numGrow_Idx, digit_Idx, num, num, target);
                continue;
            }
            //put '+' and prevNum for next level will be +num
            expres[operator_Idx] = '+';
            dfs(numArr, expres, res, numGrow_Idx, digit_Idx, num, sum + num, target);
            //put '-' and prevNum for next level will be -num
            expres[operator_Idx] = '-';
            dfs(numArr, expres, res, numGrow_Idx, digit_Idx, -num, sum - num, target);
            //put '*' and prevNum for next level will be prevNum * num
            expres[operator_Idx] = '*';
            dfs(numArr, expres, res, numGrow_Idx, digit_Idx, prevNum * num, sum - prevNum + prevNum * num, target);
        }
    }
}