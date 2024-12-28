class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
    int min = scores.get(0);
    int max = scores.get(0);
    int minX = 0;
    int maxX = 0;    
    
    for (int i = 1; i < scores.size(); i++) {
        if (scores.get(i) < min) {
            min = scores.get(i);
            minX++;
        }
        if (scores.get(i) > max) {
            max = scores.get(i);
            maxX++;
        }
    }

    List<Integer> result = new ArrayList<>();
    result.add(maxX);
    result.add(minX);
    return result;
    }

}
