package leetcode;

import java.util.*;

public class TopologicalSortCoursesDependency {
    public static String findMedianCourseI(String[][] courses) {
        Map<String, String> map = new HashMap<>();
        Set<String> nexts = new HashSet<>();
        for (String[] pair : courses) {
            map.put(pair[0], pair[1]);
            nexts.add(pair[1]);
        }
        String course = "";
        int index = courses.length / 2;
        for (String[] pair : courses) {
            if (!nexts.contains(pair[0])) {
                course = pair[0];
                while (index > 0) {
                    course = map.get(course);
                    index--;
                }
            }
        }
        return course;
    }
    public static List<String> findMedianCourseII(String[][] courses) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> nexts = new HashSet<>();
        for (String[] pair : courses) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            nexts.add(pair[1]);
        }
        List<String> order = new LinkedList<>();
        Set<String> mids = new HashSet<>();
        for (String[] pair : courses) {
            if (!nexts.contains(pair[0])) {
                dfs(pair[0], map, order, mids);
            }
        }
        return new ArrayList<>(mids);
    }
    public static void dfs(String course, Map<String, List<String>> map, List<String> order, Set<String> mids) {
        if (!map.containsKey(course)) {
            order.add(course);
            mids.add(order.get((order.size() - 1) / 2));
            order.remove(order.size() - 1);
            return;
        }
        order.add(course);
        for (String next : map.get(course)) {
            dfs(next, map, order, mids);
        }
        order.remove(order.size() - 1);
    }
}
