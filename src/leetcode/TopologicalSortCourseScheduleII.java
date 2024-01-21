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
        List<Integer> reverse = new ArrayList<>();
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
            if (!dfs(map, status, course, reverse)) {
                return new int[0];
            }
        }
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            order[i] = reverse.get(numCourses - 1 - i);
        }
        return order;
    }
    public boolean dfs(Map<Integer, List<Integer>> map, int[] status, int course, List<Integer> reverse) {
        if (status[course] == 1) {
            return false;
        }
        if (status[course] == 2) {
            return true;
        }
        status[course] = 1;
        for (int next : map.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(map, status, next, reverse)) {
                return false;
            }
        }
        status[course] = 2;
        reverse.add(course);
        return true;
    }
    //bfs
    public int[] FindOrder(int numCourses, int[][] prerequisites) {
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