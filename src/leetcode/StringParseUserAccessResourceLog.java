package leetcode;

import java.util.*;

public class StringParseUserAccessResourceLog {
    /* logs =
        {
            {"58523", "user_1", "resource_1"},
            {"62314", "user_2", "resource_2"},
            {"54001", "user_1", "resource_3"},
            {"200", "user_6", "resource_5"},
            {"215", "user_6", "resource_4"},
            {"54060", "user_2", "resource_3"},
            {"53760", "user_3", "resource_3"},
            {"58522", "user_22", "resource_1"},
            {"53651", "user_5", "resource_3"},
            {"2", "user_6", "resource_1"},
            {"100", "user_6", "resource_6"},
            {"400", "user_7", "resource_2"},
            {"100", "user_8", "resource_6"},
            {"54359", "user_1", "resource_3"},
        }
    */
    // Q1: Return each user's min and max access timestamp
    public static Map<String, List<Integer>> getUserMinMaxAccessTime(String[][] logs) {
        Map<String, List<Integer>> res = new HashMap<>();
        for (String[] log : logs) {
            String user = log[1];
            Integer time = Integer.parseInt(log[0]);
            String resource = log[2];
            res.putIfAbsent(user, Arrays.asList(time, time));
            List<Integer> times = res.get(user);
            if (times.get(0) > time) {
                // update min
                times.set(0, time);
            } else if (times.get(1) < time) {
                // update max
                times.set(1, time);
            }
        }
        return res;
    }
    // Q2: Returns the resource with the highest number of accesses in any 5 minutes window, together with how many accesses it saw
    public Map<String, Integer> findHottestResourceIn5MinWindow(String[][] logs) {
        Map<String, List<Integer>> resToTime = new HashMap<>();
        for (String[] log : logs) {
            Integer time = Integer.parseInt(log[0]);
            String resource = log[2];
            resToTime.putIfAbsent(resource, new ArrayList<>());
            resToTime.get(resource).add(time);
        }
        String resourceName = "";
        int maxCount = 0;
        for (String name : resToTime.keySet()) {
            List<Integer> record = resToTime.get(name);
            Collections.sort(record);
            int left = 0;
            int right = 0;
            int currCount = 0;
            int currMaxCount = 0;
            while (left < record.size()) {
                while (right < record.size() && record.get(left) + 300 <= record.get(right)) {
                    currCount ++;
                    right ++;
                }
                currMaxCount = Math.max(currMaxCount, currCount);
                left ++;
                currCount --;
            }
            if (currMaxCount > maxCount) {
                maxCount = currMaxCount;
                resourceName = name;
            }
        }
        Map<String, Integer> res = new HashMap<>();
        res.put(resourceName, maxCount);
        return res;
    }
    // Q3: Write a function that takes the logs as input, builds the transition graph and returns it as an adjacency list with probabilities. Add START and END states.
    // Specifically, for each resource, we want to compute a list of every possible next step taken by any user, together with the corresponding probabilities.
    // The list of resources should include START but not END, since by definition END is a terminal state.
    public static Map<String, Map<String, Double>> buildResourcePossibilityMapping(String[][] logs) {
        if (logs == null || logs.length == 0) {
            return new HashMap<>();
        }
        // sort the logs by user & time
        Arrays.sort(logs, (log1, log2) -> (log1[1].compareTo(log2[1]) != 0 ? log1[1].compareTo(log2[1])
                : Integer.parseInt(log1[0]) - Integer.parseInt(log2[0])));
        Map<String, List<String>> track = new HashMap<>();
        track.put("START", new ArrayList<String>());
        for (int i = 0; i < logs.length; i++) {
            String[] log = logs[i];
            track.putIfAbsent(log[2], new ArrayList<String>());
            // if current resource is START
            if (i == 0 || !log[1].equals(logs[i - 1][1])) {
                track.get("START").add(log[2]);
            }
            // if current resource is END
            if (i == logs.length - 1 || !log[1].equals(logs[i + 1][1])) {
                track.get(log[2]).add("END");
            }
            // connect current resource with previous one
            if (i > 0 && log[1].equals(logs[i - 1][1])) {
                track.get(logs[i - 1][2]).add(log[2]);
            }
        }
        Map<String, Map<String, Double>> possibility = new HashMap<>();
        for (String key : track.keySet()) {
            possibility.put(key, getFreq(track.get(key)));
        }
        return possibility;
    }
    public static Map<String, Double> getFreq(List<String> nexts) {
        Map<String, Double> map = new HashMap<>();
        for (String next : nexts) {
            map.put(next, map.getOrDefault(next, (double)0) + 1);
        }
        for (String key : map.keySet()) {
            double prob = (double)(map.get(key) / nexts.size());
            map.put(key, (double)Math.round(prob * 1000) / 1000);
        }
        return map;
    }
}
