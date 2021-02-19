package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TrieMaxXOR {
    static class TrieNode {
        Map<Character, TrieNode> map;
        TrieNode() {
            this.map = new HashMap<Character, TrieNode>();
        }
    }
    public int findMaximumXOR(int[] nums) {
        int maxLen = 0;
        for (int num : nums) {
            maxLen = Math.max(Integer.toBinaryString(num).length(), maxLen);
        }
        int bitMask = 1 << maxLen;
        String[] binaryStr = new String[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            binaryStr[i] = Integer.toBinaryString(bitMask | nums[i]).substring(1);
        }
        int maxXORVal = 0;
        TrieNode root = new TrieNode();
        for (String binary : binaryStr) {
            TrieNode node = root;
            TrieNode xor = root;
            int XORValue = 0;
            for (char c : binary.toCharArray()) {
                if (!node.map.containsKey(c)) {
                    node.map.put(c, new TrieNode());
                }
                node = node.map.get(c);
                char toggled = c == '1' ? '0' : '1';
                if (!xor.map.containsKey(toggled)) {
                    XORValue = XORValue << 1;
                    xor = xor.map.get(c);
                } else {
                    XORValue = (XORValue << 1) | 1;
                    xor = xor.map.get(toggled);
                }
            }
            maxXORVal = Math.max(XORValue, maxXORVal);
        }
        return maxXORVal;
    }
}
