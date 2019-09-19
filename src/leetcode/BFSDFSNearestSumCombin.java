package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFSDFSNearestSumCombin {
    public List<List<Integer>> find (int[] arr1, int[] arr2, int target) {
        if (arr1==null || arr2==null || arr1.length * arr2.length ==0) {
            return null;
        }
        ArrayList<List<Integer>> resultSet = new ArrayList<List<Integer>>();
        //sort two arrays for convenience to traverse
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int diff = target - (arr1[0] + arr2[0]);
        for (int i = 0;i < arr1.length;i++ ) {
            //check if this element plus the smallest one in arr2 greater than target
            //if greater, then no need to continue
            if (arr1[i] + arr2[0] > target) {
                return resultSet;
            }
            for (int j = 0;j < arr2.length;j++) {
                //if sum greater than target, then start over with next arr1 element
                if (arr1[i] + arr2[j] > target) {
                    break;
                }
                //if sum plus diff still less than target, then the combination is clearly not the nearest
                if (arr1[i] + arr2[j] + diff < target) {
                    continue;
                }
                //if sum plus diff equals to target, then this combination meets the current smallest diff
                if (arr1[i] + arr2[j] + diff == target) {
                    //add this combination
                    resultSet.add(new ArrayList<>(Arrays.asList(arr1[i],arr2[j])));
                }
                //if sum plus diff greater than target, then we found a smaller diff, means this combination nearer than previous ones
                if (arr1[i] + arr2[j] + diff > target) {
                    //all previous combinations need to delete
                    resultSet.clear();
                    resultSet.add(new ArrayList<>(Arrays.asList(arr1[i],arr2[j])));
                    //update new diff
                    diff = target - arr1[i] - arr2[j];
                }
            }
        }
        return resultSet;
    } 
}