package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAndPQSimplifyPath {
    public String simplifyPath(String path) {
        if (path.length()<=1){
            return path;
        }
        Deque<String> stack = new ArrayDeque<>();
        String [] strings = path.split("/");
        //array strings contains "", should not be considered
        for (String str:strings){
            //string use .equals()
            //char use ==
            if (str.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if (!str.equals(".")&&!str.isEmpty()){
                stack.push(str);
            }
        }
        if (stack.isEmpty()){
            return "/";
        }
        String string = "";
        while (!stack.isEmpty()){
            string = "/"+stack.pop()+string;
        }
        return string;
    }
    //simplified method
    public String SimplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<String>();
        for (String s : path.split("/")) {
            if (s.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
            else if (!s.equals(".") && !s.equals("..") && !s.equals("")){
                stack.push(s);
            }
        }
        return "/" + String.join("/", stack);
    }
}