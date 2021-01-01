package leetcode;

import java.util.*;

public class StringAnalyzeUserWebsiteVisit {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Record>> map = new HashMap<>();
        for (int i = 0; i < username.length; i ++) {
            String name = username[i];
            String site = website[i];
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<Record>());
            }
            map.get(name).add(new Record(timestamp[i], site));
        }
        List<String> seq_list = new ArrayList<>();
        for (String name : map.keySet()) {
            if (map.get(name).size() >= 3) {
                List<Record> list = map.get(name);
                Collections.sort(list, new Comparator<Record>(){
                    @Override
                    public int compare(Record a, Record b) {
                        return a.timeStamp - b.timeStamp;
                    }
                });
                getAllSequence(list, new StringBuilder(), new HashSet<String>(), seq_list, 0, 3);
            }
        }
        int max = 0;
        String res = null;
        Map<String, Integer> record = new HashMap<>();
        for (String seq : seq_list) {
            record.put(seq, record.getOrDefault(seq, 0) + 1);
            if (record.get(seq) > max) {
                res = seq;
                max = record.get(seq);
            } else if (record.get(seq) == max) {
                if (seq.compareTo(res) < 0) {
                    res = seq;
                }
            }
        }
        return Arrays.asList(res.split(","));
    }
    public void getAllSequence(List<Record> list, StringBuilder sb, Set<String> set, List<String> res, int index, int needed) {
        if (needed == 0) {
            String seq = new String(sb);
            if (!set.contains(seq)) {
                res.add(seq);
                set.add(seq);
            }
            return;
        }
        if (index < list.size()) {
            String site = list.get(index).website;
            sb.append(site);
            sb.append(',');
            getAllSequence(list, sb, set, res, index + 1, needed - 1);
            sb.delete(sb.length() - site.length() - 1, sb.length());
            getAllSequence(list, sb, set, res, index + 1, needed);
        }
    }
    class Record {
        int timeStamp;
        String website;
        Record(int time, String site) {
            this.timeStamp = time;
            this.website = site;
        }
    }
}
