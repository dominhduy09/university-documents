class Result {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
    // Write your code here
        s = s.toLowerCase();
        
        HashSet<Character> letters = new HashSet<>();
        
        for (char ch : s.toCharArray()) {
            if (ch>='a' && ch<='z') {
                letters.add(ch);
            }
        }
        return (letters.size() == 26) ? "pangram" : "not pangram";  
    }
}