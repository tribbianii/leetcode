package leetcode;

import java.util.*;

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
    //dfs method
    public boolean CanFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pair: prerequisites) {
            int pre = pair[1];
            int sub = pair[0];
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new HashSet<Integer>());
            }
            map.get(pair[1]).add(pair[0]);
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int id : map.keySet()) {
            if(!checkCircle(map, visited, id)) {
                return false;
            }
        }
        return true;
    }
    public boolean checkCircle(Map<Integer, Set<Integer>> map, Map<Integer, Boolean> visited, int id) {
        if (visited.containsKey(id)) {
            return visited.get(id);
        }
        if (!map.containsKey(id)) {
            visited.put(id, true);
            return true;
        }
        visited.put(id, false);
        for (int pre : map.get(id)) {
            if (!checkCircle(map, visited, pre)) {
                return false;
            }
        }
        visited.put(id, true);
        return true;
    }
}