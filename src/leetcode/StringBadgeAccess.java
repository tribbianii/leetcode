package leetcode;

import java.util.*;

public class StringBadgeAccess {
    // Q1
    public static List<List<String>> findMismatchedEntries(List<List<String>> records) {
        Set<String> missExit = new HashSet<>();
        Set<String> missEntry = new HashSet<>();
        Map<String, Boolean> status = new HashMap<>();
        for (List<String> record : records) {
            String name = record.get(0);
            String activity = record.get(1);
            if (activity.equals("exit")) {
                if (!status.containsKey(name) || !status.get(name)) {
                    missEntry.add(name);
                }
                status.put(name, false);
            } else {
                if (status.containsKey(name) && status.get(name)) {
                    missExit.add(name);
                }
                status.put(name, true);
            }
        }
        for (String name : status.keySet()) {
            if (status.get(name)) {
                missExit.add(name);
            }
        }
        return Arrays.asList(new ArrayList(missExit), new ArrayList(missEntry));
    }
    // Q2
    public static Map<String, List<String>> activities(List<List<String>> logs) {
        Map<String, List<String>> record = new HashMap<>();
        for (List<String> log : logs) {
            record.putIfAbsent(log.get(0), new ArrayList<>());
            record.get(log.get(0)).add(log.get(1));
        }
        Map<String, List<String>> activities = new HashMap<>();
        for (String name : record.keySet()) {
            List<String> activity = record.get(name);
            activity.sort((a, b) -> (Integer.compare(Integer.parseInt(a), Integer.parseInt(b))));
            int left = 0;
            int right = 0;
            while (left < activity.size() && right < activity.size()) {
                int period = Integer.parseInt(activity.get(right)) - Integer.parseInt(activity.get(left));
                if (period <= 100) {
                    if (right == activity.size() - 1 && right - left >= 2) {
                        activities.put(name, new ArrayList<>());
                        while (left <= right) {
                            activities.get(name).add(activity.get(left));
                            left ++;
                        }
                        break;
                    }
                    right ++;
                } else if (right - left >= 3) {
                    activities.put(name, new ArrayList<>());
                    while (left < right) {
                        activities.get(name).add(activity.get(left));
                        left ++;
                    }
                    break;
                } else {
                    left ++;
                }
            }
        }
        return activities;
    }
}
