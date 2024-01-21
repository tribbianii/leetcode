package leetcode;

import java.util.TreeMap;

public class oa {

    public class shipmentImbalance
    {
        int solve(int arr[],int k)
        {
            int length=arr.length;
            int count[]=new int[length];
            count[0]=1;
            int start=0;
            TreeMap<Integer,Integer> treeMap=new TreeMap<>();
            treeMap.put(arr[0],treeMap.getOrDefault(arr[0],0)+1);
            for (int i=1;i<length;i++)
            {
                int ele=arr[i];
                treeMap.put(ele,treeMap.getOrDefault(ele,0)+1);
                while ((treeMap.lastKey()-treeMap.firstKey())>k)
                {
                    treeMap.put(arr[start],treeMap.get(arr[start])-1);
                    if (treeMap.get(arr[start])==0)
                    {
                        treeMap.remove(arr[start]);
                    }
                    start++;
                }
                count[i]=i-start+1;
            }
            int ans=0;
            for (int ele:count)
            {
                ans+=ele;
            }
            return ans;
        }
    }
}
