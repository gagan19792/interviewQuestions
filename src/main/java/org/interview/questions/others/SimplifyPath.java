package org.interview.questions.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println("Expected Path {\"/home/user/Pictures\"} : Actual Path : "+simplifyPathWithStack("/home/user/Documents/../Pictures"));
    }

    public static String simplifyPath(String path){
        List<String> dirs = new ArrayList<>();
        for(String dir: path.split("/")){
            if(dir.isEmpty() || dir.equals(".")){
                continue;
            }
            if(dir.equals("..")){
                if(!dirs.isEmpty()){
                    dirs.remove(dirs.size()-1);
                }
            }else{
                dirs.add(dir);
            }
        }
        return "/"+String.join("/", dirs);
                
    }

    public static String simplifyPathWithStack(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for(String directory: components){
            if(directory.equals(".") || directory.isEmpty()){
                continue;
            }else if(directory.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.add(directory);
            }
        }
        StringBuilder result = new StringBuilder();
        for(String dir: stack){
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString():"/";
    }

}
