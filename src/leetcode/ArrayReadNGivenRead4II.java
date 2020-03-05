package leetcode;

public class ArrayReadNGivenRead4II {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0) {
                buffCnt = read4(buff);
            }
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
            // all chars in buff used up, set pointer to 0
            if (buffPtr == buffCnt) {
                buffPtr = 0;
            }// read4 returns less than 4, end of file
            if (buffCnt < 4) {
                break;
            }
        }
        return ptr;
    }

    private int read4(char[] buff) {
        return 0;
        //return the actully read data length
        //expected to return 4 if unredad data more than 4
        //else return less than 4
    }
}