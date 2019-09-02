package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFSDFSWordLadderII {
    //my method exceeded time limit when wordList become large
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)){
            return res;
        }
        ArrayList<Set<Character>> charset = new ArrayList<Set<Character>>();
        int len = beginWord.length();
        for (int i=0;i<len;i++){
            Set<Character> set = new HashSet<Character>();
            for (String word:wordList){
                set.add(word.charAt(i));
            }
            charset.add(new HashSet<Character>(set));
        }
        ArrayList<String> seq = new ArrayList<String>();
        seq.add(beginWord);
        helper(res, wordSet, charset, beginWord, endWord, seq);
        int minLen = Integer.MAX_VALUE;
        for (int j=0;j<res.size();j++){
            minLen=Math.min(minLen,res.get(j).size());
        }
        for (int i=0;i<res.size();i++){
            if (res.get(i).size()!=minLen){
                res.remove(i);
                i--;
            }
        }
        return res;
    }
    private void helper(ArrayList<List<String>> res,Set<String> wordSet,ArrayList<Set<Character>> charset,String beginWord,String endWord,ArrayList<String> seq){
        if (seq.size()==res.get(res.size()-1).size() && !beginWord.equals(endWord)){
            return;
        }
        if (beginWord.equals(endWord)){
            res.add(new ArrayList<String>(seq));
        }
        char[] chars = beginWord.toCharArray();
        for (int index=0;index<beginWord.length();index++){
            char prev = beginWord.charAt(index);
            for (char c:charset.get(index)){
                if (c!=chars[index]){
                    chars[index]=c;
                    String next = new String(chars);
                    if (wordSet.contains(next)){
                        wordSet.remove(next);
                        seq.add(next);
                        helper(res, wordSet, charset, next, endWord, seq);
                        wordSet.add(next);
                        seq.remove(seq.size()-1);
                    }
                    chars[index]=prev;
                    continue;
                }
            }
        }
    }
    //following is solution
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if (dict.size()==0 || !dict.contains(end)){
            return result;
        }
        int curr=1,next=0;	        
        boolean found=false;	        
        List<String> list = new LinkedList<String>();	
        list.add(end);       
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        Queue<String> queue= new ArrayDeque<String>();
        Set<String> unvisited = new HashSet<String>(dict);
        Set<String> visited = new HashSet<String>();
        queue.add(start);
        unvisited.remove(start);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curr--;				
            for (int i = 0; i < word.length(); i++){
                StringBuilder builder = new StringBuilder(word); 
                for (char ch='a';  ch <= 'z'; ch++){
                    builder.setCharAt(i,ch);
                    String new_word=builder.toString();	
                    if (unvisited.contains(new_word)){
                        if (visited.add(new_word)){
                        //set.add(element) return boolean value
                        //if element already existed in set, return false, do nothing
                        //if doesn't exist, return true, add element into set
                        //equals to if(!set.contains(ele))->then set.add(ele)
                            next++;
                            queue.add(new_word);
                        }
                        if (map.containsKey(new_word))//Build Adjacent Graph
                            map.get(new_word).add(word);
                        else{
                            List<String> l= new LinkedList<String>();
                            l.add(word);
                            map.put(new_word, l);
                        }
                        if (new_word.equals(end) && !found) {
                            found=true;
                        }                           
                    }
                }
            }
            if (curr==0){
                if (found) {
                    break;
                }
                curr=next;
                next=0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }
        backTrace(end,start,list,map,result);
        return result;        
    }
    private void backTrace(String word,String start,List<String>list,Map<String,List<String>> map,ArrayList<List<String>> result){
        if (word.equals(start)){
            result.add(new ArrayList<String>(list));
            return;
        }
        if (map.get(word)!=null){
            for (String s:map.get(word)){
                //backtracking
                list.add(0,s);
                backTrace(s,start,list,map,result);
                list.remove(0);
            }
        }
    }
}