package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayFindCommonEle{
    public static List<Integer> findCommon(List<Integer>list_1, List<Integer>list_2) {
        List<Integer> res = new ArrayList<Integer>();
        if (list_1==null || list_2==null || list_1.size() * list_2.size()==0) {
            return res;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (Integer ele_1 : list_1) {
            set.add(ele_1);
        }
        for (Integer ele_2 : list_2) {
            if (set.contains(ele_2)) {
                res.add(ele_2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list_1 = new ArrayList<Integer>();
        //List<Integer> list_2 = new ArrayList<Integer>();
        List<Integer> list_2 = null;
        list_1.add(1);
        list_1.add(3);
        list_1.add(5);
        //list_2.add(2);
        //list_2.add(5);
        //list_2.add(6);
        System.out.println(Arrays.toString(findCommon(list_1, list_2).toArray()));
    }
}