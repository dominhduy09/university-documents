class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            int type = Integer.parseInt(parts[0]);

            if (type == 1) {
                // Push operation
                int x = Integer.parseInt(parts[1]);
                stack.push(x);
                if (maxStack.isEmpty()) {
                    maxStack.push(x);
                } else {
                    maxStack.push(Math.max(x, maxStack.peek()));
                }
            } else if (type == 2) {
                // Pop operation
                if (!stack.isEmpty()) {
                    stack.pop();
                    maxStack.pop();
                }
            } else if (type == 3) {
                // Max operation
                if (!maxStack.isEmpty()) {
                    result.add(maxStack.peek());
                }
            }
        }

        return result;
    }

}