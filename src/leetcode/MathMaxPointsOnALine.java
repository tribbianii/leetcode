package leetcode;

import java.util.HashMap;
import java.util.Map;
public class MathMaxPointsOnALine {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    public int maxPoints(Point[] points) {
        if (points==null||points.length==0){
            return 0;
        }
        //set the initial num of point to 1
        int max = 1;
        for (int i=0;i<points.length;i++){
            //set a variable to calculate max number of points on a line crossing points[i]
            int num = 1;
            //record the appearance of points with same location with points[i]
            int self = 0;
            //record the appearance of lines crossing points[i] with different slopes 
            Map<Point,Integer> map = new HashMap<>();
            for (int j=i+1;j<points.length;j++){
                if (points[j].x==points[i].x && points[j].y==points[i].y){
                    self++;
                    continue;
                }
                //set a boolean variable to record
                //whether points[j] shares an existing line with points[i]
                boolean online = false;
                long diff_x = points[j].x-points[i].x;
                long diff_y = points[j].y-points[i].y;
                for (Point slope:map.keySet()){
                    if (diff_x * slope.y==diff_y * slope.x){
                        map.put(slope,map.get(slope)+1);
                        online = true;
                        break;
                    }
                }
                //if points[j] not on any existing line with points[i]
                //then "draw a new line" with new slope added in map
                if (online==false){
                    map.put(new Point((int)diff_x,(int)diff_y),2);
                }
            }
            num += self;
            //get the max num of points on a line crossing points[i] 
            for (int number:map.values()){
                num = number+self>=num?number+self:num;
            }
            //get the max num of points on a line
            max = num>=max?num:max;
        }
        return max;
    }
}