package leetcode;

public class ArrayMagicArray {
    public int maxSize (int[][] Arr) {
        if (Arr.length<1 || Arr==null) {
            return 0;
        }
        int len = Arr.length;
        for (int size=len; size>0; size--) {
            for (int offset_x=0; offset_x<=len-size; offset_x++) {
                for (int offset_y=0; offset_y<=len-size; offset_y++) {
                    if (valid(Arr, offset_x, offset_y, size)) {
                        return size;
                    }
                }
            }
        }
        return Arr.length;
    }
    private boolean valid (int[][] arr, int start_x, int start_y, int size) {
        int end_x = start_x + size - 1;
        int sum1 = 0;
        int sum2 = 0;
        for (int i=0; i<size; i++) {
            sum1 = sum1 + arr[start_x][start_y];
            sum2 = sum2 + arr[end_x][start_y];
            start_x++;
            start_y++;
            end_x--;
        }
        return sum1==sum2;
    }
}