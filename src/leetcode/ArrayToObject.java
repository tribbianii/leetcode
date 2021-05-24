package leetcode;

import java.util.*;

public class ArrayToObject {
    static String[][] arr = new String[][]{
            {"node", "a", "children", "b,c"},
            {"node", "d", "children", "a"},
            {"node", "b", "children", "i,e"},
            {"node", "c", "children", "f"},
            {"node", "f", "children", "g"},
            {"node", "e", "children", "h"}
    };
    //建表用来存 node 和 children 的关系
    static Map<Character, List<Character>> graph = new HashMap<>();
    //建集用来存所有的 children
    static Set<Character> childrenSet = new HashSet<>();
    //遍历数组
    static void buildGraph(String[][] input) {
        for (String[] row : input) {
            //找到此 node 的 key
            char myKey = row[1].charAt(0);
            //找到此 node 的所有 children，加到 list 里
            List<Character> myChildren = new ArrayList<>();
            String[] children = row[3].split(",");
            for (String child : children) {
                char childKey = child.charAt(0);
                myChildren.add(childKey);
                //把此 child 存到集里
                childrenSet.add(childKey);
            }
            //把此 node 和其 children list 存入表中
            graph.put(myKey, myChildren);
        }
    }
    //找到祖先 node，祖先 node 一定不存在于 children set 中，一定存在于 graph 中
    static char findAncestorKey() {
        for (char key : graph.keySet()) {
            if (!childrenSet.contains(key)) {
                return key;
            }
        }
        return '.';
    }
    //打印整个 graph，用到 recursion
    static String printGraph(char key) {
        String result = key + " : ";
        if (!graph.containsKey(key)) {
            result = result + "null ";
            return result;
        }
        result = result + "{ ";
        List<Character> childrenList = graph.get(key);
        int childrenNum = graph.get(key).size();
        for (int i = 0; i < childrenNum; i++) {
            result = result + printGraph(childrenList.get(i));
            if (i < childrenNum - 1) {
                result = result + ", ";
            }
        }
        result = result + "} ";
        return result;
    }

    public static void main(String[] args) {
        buildGraph(arr);
        char ancestor = findAncestorKey();
        System.out.println(printGraph(ancestor));
    }
}
    /*

    //每个 node 有两个值，分别是自己的 key，和自己的 children 列表
    static class Node {
        char key;
        List<Node> children;
        Node(char key) {
            this.key = key;
            this.children = new ArrayList<>();
        }
    }
    //存储 key 和 node 的对应关系
    static Map<Character, Node> keyToNode = new HashMap<>();
    //存储 所有的 children 的 key
    static Set<Character> allChildren = new HashSet<>();
    //开始遍历 arr
    static void buildGraph(String[][] input) {
        for (String[] row : input) {
            char key = row[1].charAt(0);
            //先查看是否存储过此 key，如果没存过，就新建 node，并存下 key - node 的对应关系
            if (!keyToNode.containsKey(key)) {
                keyToNode.put(key, new Node(key));
            }
            Node selfNode = keyToNode.get(key);
            //遍历此 node 的所有 child key
            String[] children = row[3].split(",");
            for (String child : children) {
                char childKey = child.charAt(0);
                //将 child key 存入 set
                allChildren.add(childKey);
                //同样的，先查看有没有存过这个 child，没存过就新建并存入
                if (!keyToNode.containsKey(childKey)) {
                    keyToNode.put(childKey, new Node(childKey));
                }
                //把这个 node 放进 selfNode 的 children 列表里
                Node childNode = keyToNode.get(childKey);
                selfNode.children.add(childNode);
            }
        }
    }
    //有且仅有一个 key 在 map 里却不在 set 里，找到此 key 并返回对应的 node （祖先 node， 因为祖先不是任何一个 node 的 child）
    static Node findAncestor() {
        for (char key : keyToNode.keySet()) {
            if (!allChildren.contains(key)) {
                return keyToNode.get(key);
            }
        }
        return null;
    }
    //从祖先 node 开始打印，recursion
    static String printNode(Node ancestor) {
        //打印自己的 key 值
        String output = ancestor.key + " : ";
        //如果没有 child
        if (ancestor.children.size() == 0) {
            output = output + "null";
            return output;
        }
        //如果有 child
        //打印左大括号
        output = output + "{ ";
        for (int i = 0; i < ancestor.children.size(); i ++) {
            output = output + printNode(ancestor.children.get(i)) ;
            //只在 children 之间加逗号
            if (i < ancestor.children.size() - 1) {
                output = output + ",";
            }
        }
        //打印右大括号
        output = output + "} ";
        return output;
    }
    public static void main(String[] args) {
        //先建 map 和 set
        buildGraph(arr);
        //找到祖先 node
        Node ancestor = findAncestor();
        //从祖先 node 开始输出
        System.out.println(printNode(ancestor));
    }

     */
