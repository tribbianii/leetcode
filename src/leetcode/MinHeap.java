package leetcode;

import java.util.NoSuchElementException;

public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array cannot be null or empty");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    public MinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity canot be <= 0");
        }
        array = new int[cap];
        size = 0;
    }
    
    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[parentIndex] > array[index]) {
                swap(array, parentIndex, index);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    private void percolateDown(int index) {
        while (index <= (size - 2) / 2) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = leftChildIndex + 1;
            int swapIndex = ( rightChildIndex < size 
                            && array[leftChildIndex] >= array[rightChildIndex] )
                            ? rightChildIndex 
                            : leftChildIndex;
            if (array[index] > array[swapIndex]) {
                swap(array, index, swapIndex);
            } else {
                break;
            }
            index = swapIndex;
        }
    }

    public int peek() {
        return  size == 0 ? -1 : array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        int result = array[0];
        array[0] = array[size - 1];
        size --;
        percolateDown(0);
        return result;
    }

    public void offer(int ele) {
        if (size == array.length) {
            int[] newArray = new int[(int)(array.length * 1.5)];
            copy(array, newArray);
            array = newArray;
        }
        array[size] = ele;
        size ++;
        percolateUp(size - 1);
    }

    private void copy(int[] array_1, int[] array_2) {
        for (int i = 0; i < array_1.length; i ++) {
            array_2[i] = array_1[i];
        }
    }

    //return the orignal value
    public int update(int index, int ele) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("invalid index range");
        }
        int result = array[index];
        array[index] = ele;
        if (result > ele) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        return result;
    }
}