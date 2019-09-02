package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackTrackingReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        int sta_num = tickets.length+1;
        List<String> res = new ArrayList<>();
        String start = "JFK";
        res.add(start);
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0;i<tickets.length;i++){
            if (!map.containsKey(tickets[i][0])){
                ArrayList<String> des = new ArrayList<>();
                des.add(tickets[i][1]);
                map.put(tickets[i][0],des);
            }
            else {
                map.get(tickets[i][0]).add(tickets[i][1]);
            }
        }
        for (String from:map.keySet()){
            Collections.sort(map.get(from));
        }
        dfs(map,start,res,sta_num);
        return res;
    }
    //if change dfs to void, it would run out of memory when input get large
    private boolean dfs(Map<String, List<String>> map,String from,List<String> res,int sta_num){
        if (res.size()==sta_num){
            return true;
        }
        if (!map.containsKey(from)){
            return false;
        }
        List<String> des_list = map.get(from);
        for (int i=0;i<des_list.size();i++){
            String next = des_list.get(i);
            res.add(next);
            des_list.remove(i);
            if (dfs(map,next,res,sta_num)){
                return true;   
            }
            res.remove(res.size()-1);
            des_list.add(i, next);
        }
        return false;
    }
}