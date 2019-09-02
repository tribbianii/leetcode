package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFSDFSWordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        //for convenience to ensure whether new formed word exists in wordList, to remove already used words
        //no way to reach endword if it doesn't exist
        //NOTE: following convert list to set
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)){
            return 0;
        }
        //every index of words have a correspinding set containing all character candidates appearing on that index
        //for saving time, when replace character, we don't have to traverse from 'a' to 'z'
        ArrayList<Set<Character>> charset = new ArrayList<Set<Character>>();
        for (int i=0;i<len;i++){
            Set<Character> set = new HashSet<Character>();
            for (String word:wordList){
                set.add(word.charAt(i));
            }
            charset.add(new HashSet<Character>(set));
        }
        //start BFS
        int seqlen = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()){
            seqlen++;
            int qsize = q.size();
            for (int i=0;i<qsize;i++){
                String word = q.poll();
                for (int j=0;j<len;j++){
                    char[] chars = word.toCharArray();
                    for (char c:charset.get(j)){
                        if (c!=chars[j]){
                            chars[j]=c;
                            //NOTE: following convert Char array to string
                            String wordy = new String(chars);
                            //NOTE: following determine whether strings are same
                            if (wordy.equals(endWord)){
                                return seqlen;
                            }
                            if (wordSet.contains(wordy)){
                                wordSet.remove(wordy);
                                q.add(wordy);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}