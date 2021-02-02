package leetcode;

public class BinarySearchSearchInSortedArrayOfUnknownSize {
    interface ArrayReader {
        // return the value in the array at index, all values insides less than 10000
        // return 10000 if index out of bound
        public int get(int index);
   }
    public int search(ArrayReader reader, int target) {
        int prevGuess = -1;
        int currGuess = 0;
        int index = 0;
        boolean foundBound = false;
        while (prevGuess < currGuess) {
            if (!foundBound) {
                int resp = reader.get(currGuess);
                if (resp == target) {
                    return currGuess;
                } else if (resp > 10000) {
                    currGuess = prevGuess + (currGuess - prevGuess) / 2;
                } else if (resp < target) {
                    prevGuess = currGuess;
                    currGuess = (int)Math.pow(2, index ++);
                } else {
                    foundBound = true;
                }
            } else {
                int mid = prevGuess + (currGuess - prevGuess) / 2;
                int resp = reader.get(mid);
                if (resp == target) {
                    return mid;
                } else if (resp > target) {
                    currGuess = mid - 1;
                } else {
                    prevGuess = mid + 1;
                }
            }
        }
        return reader.get(currGuess) == target ? currGuess : -1;
    }
}
