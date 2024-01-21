package leetcode;

import java.util.*;

public class TopologicalSortCourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] order : prerequisites) {
            if (!map.containsKey(order[1])) {
                map.put(order[1], new ArrayList<>());
            }
            map.get(order[1]).add(order[0]);
        }
        int[] status = new int[numCourses];
        //status[i] denotes the status of the visit from course i
        //status[i] = 0: course i hasn't been visited
        //status[i] = 1: in visiting the descendants of course i
        //status[i] = 2: course i and its descendants has been visited
        for (int course = 0;  course < numCourses; course ++) {
            if (!dfs(map, status, course)) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(Map<Integer, List<Integer>> map, int[] status, int course) {
        if (status[course] == 1) {
            return false;
        }
        if (status[course] == 2) {
            return true;
        }
        status[course] = 1;
        for (int next : map.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(map, status, next)) {
                return false;
            }
        }
        status[course] = 2;
        return true;
    }
    //bfs
    public boolean CanFinish(int numCourses, int[][] prerequisites) {
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