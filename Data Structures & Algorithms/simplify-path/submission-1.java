class Solution {
    // /neetcode/practice//...///../courses

    // 
    // /../ parent
    // /./ current
    // /..abc folder or file
    // abc../ folder or file
    //abc.txt // file name

    
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for (String curr: paths) {
            if (curr.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!curr.equals("") && !curr.equals(".")) {
                stack.push(curr);
            }
        }


        return "/" + String.join("/", stack);
    }
}