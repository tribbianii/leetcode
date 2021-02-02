package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchFindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                left = mid;
                right = left + 1;
                break;
            } else if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        while (res.size() < k) {
            if (left < 0) {
                res.add(arr[right ++]);
            } else if (right >= arr.length) {
                res.add(arr[left --]);
            } else {
                res.add(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? arr[left --] : arr[right ++]);
            }
        }
        Collections.sort(res);
        return res;
    }
    //above is my method
    //here comes the python-like solution
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        Collections.sort(arr, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
   }
}