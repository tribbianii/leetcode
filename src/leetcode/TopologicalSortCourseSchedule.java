package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortCourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!NoNeedprep.isEmpty()){
            int prep = NoNeedprep.poll();
            List<Integer> then = map.get(prep);
            for (int j=0;then!=null&&j<then.size();j++){
                precourse_num[then.get(j)]--;
                if (precourse_num[then.get(j)]==0){
                    NoNeedprep.offer(then.get(j));
                }
            }
        }
        for (int number:precourse_num){
            if (number!=0){
                return false;
            }
        }
        return true;
    }
}