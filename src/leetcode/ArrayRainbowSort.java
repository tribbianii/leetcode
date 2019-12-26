package leetcode;

class ArrayRainbowSort {
    //['a','c','b','c','a','b'] --> ['a','a','b','b','c','c']
    public char[] rainbowSort (char[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int left = 0;
        int mid = 0;
        int right = arr.length - 1;
        /*
        [0, left) -> a
        [left, mid) -> b
        (right, end] -> c
        [mid, right] -> unvisited
        */
        while (mid <= right) {
            if (arr[mid] == 'a') {
                swap(arr, left++, mid++);
            }
            else if (arr[mid] == 'b') {
                mid++;
            }
            else {
                swap(arr, mid, right--);
            }
        }
        return arr;
    }
    public void swap (char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}