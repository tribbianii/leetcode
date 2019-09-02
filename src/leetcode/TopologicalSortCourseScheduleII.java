package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortCourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        Arrays.fill(order,-1);
        int[] precourse_num = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int[] pair:prerequisites){
            precourse_num[pair[0]]++;
            if (!map.containsKey(pair[1])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(pair[0]);
                map.put(pair[1], list);
            }
            else {
                map.get(pair[1]).add(pair[0]);
            }
        }
        Queue<Integer> NoNeedprep = new LinkedList<>();
        for (int i=0;i<numCourses;i++){
            if (precourse_num[i]==0){
                NoNeedprep.offer(i);
            }
        }
        int ordernum = 0;
        while (!NoNeedprep.isEmpty()){
            int prep = NoNeedprep.poll();
            order[ordernum] = prep;
            ordernum++;
            List<Integer> then = map.get(prep);
            for (int j=0;then!=null&&j<then.size();j++){
                precourse_num[then.get(j)]--;
                if (precourse_num[then.get(j)]==0){
                    NoNeedprep.offer(then.get(j));
                }
            }
        }
        int[] none = {};
        for (int number:precourse_num){
            if (number!=0){
                return none;
            }
        }
        return order;
    }
}