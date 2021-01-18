package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DesignGuessTheWord {
    interface Master{
        int guess(String word);
    }
    public int match(String word_1, String word_2) {
        int match = 0;
        for (int i = 0; i < word_1.length(); i ++) {
            if (word_1.charAt(i) == word_2.charAt(i)) {
                match ++;
            }
        }
        return match;
    }
    //following my method
    public void findSecretWord(String[] wordlist, Master master) {
        int match = 0;
        for (int j = 0; j < 10 && match < wordlist[0].length(); j ++) {
            String candidate = wordlist[(int) ((Math.random() * (wordlist.length - 1)))];
            match = master.guess(candidate);
            wordlist = match > 0 ? keepMatch(candidate, match, wordlist) : ruleOut(candidate, wordlist);
        }
    }
    public String[] keepMatch(String target, int match, String[] dict) {
        List<String> list = new ArrayList<>();
        for (String word : dict) {
            if (match(target, word) == match) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
    public String[] ruleOut(String target, String[] dict) {
        List<String> list = new ArrayList<>();
        for (String word : dict) {
            for (int i = 0; i < word.length(); i ++) {
                if (word.charAt(i) == target.charAt(i)) {
                    break;
                }
                if (i == word.length() - 1) {
                    list.add(word);
                }
            }
        }
        return list.toArray(new String[0]);
    }
    //following minmax solution
    public void FindSecretWord(String[] wordlist, Master master) {
        for (int t = 0, x = 0; t < 10 && x < 6; ++t) {
            int[][] count = new int[6][26];
            int best = 0;
            for (String w : wordlist)
                for (int i = 0; i < 6; ++i)
                    count[i][w.charAt(i) - 'a']++;
            String guess = wordlist[0];
            for (String w: wordlist) {
                int score = 0;
                for (int i = 0; i < 6; ++i)
                    score += count[i][w.charAt(i) - 'a'];
                if (score > best) {
                    guess = w;
                    best = score;
                }
            }
            x = master.guess(guess);
            List<String> wordlist2 = new ArrayList<String>();
            for (String w : wordlist)
                if (match(guess, w) == x)
                    wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[0]);
        }
    }
}
