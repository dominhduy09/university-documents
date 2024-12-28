class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    // Write your code here
        Stack<Character> stk = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stk.push(ch);
            }
            
            else {
                if (stk.isEmpty()) {
                    return "NO";
                }
                
                char top = stk.pop();
                    if ((ch=='}' && top!='{') || (ch==']' && top!='[') || (ch==')'&&top!='(')) {
                        return "NO";
                    }
            }
        }
        if (stk.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

}