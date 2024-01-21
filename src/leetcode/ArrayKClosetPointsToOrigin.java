package leetcode;

import java.util.Arrays;

public class ArrayKClosetPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;
        while (left <= right) {
            int mid = partition(points, left, right);
            if (mid == k) {
                break;
            } else if (mid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Arrays.copyOf(points, k);
    }

    public int partition(int[][] points, int left, int right) {
        int i = left;
        int j = right - 1;
        int pivot = distance(points[right]);
        while (i <= j) {
            int di = distance(points[i]);
            int dj = distance(points[j]);
            if (di >= pivot && dj < pivot) {
                swap(points, i ++, j --);
                continue;
            }
            i = di < pivot ? i + 1 : i;
            j = dj >= pivot ? j - 1 : j;
        }
        swap(points, i, right);
        return i;
    }

    public void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
