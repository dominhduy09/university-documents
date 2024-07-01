public class Main {
    public static void main(String[] args) {
        // Declare a variable of type MyPair<String, Integer> and create a pair
        MyPair<String, Integer> pair1 = new MyPair<>("Anders", 13);
        System.out.println("Pair 1: " + pair1); // Output: (Anders, 13)
        
        // Declare a variable of type MyPair<String, Double> and create a pair
        MyPair<String, Double> pair2 = new MyPair<>("Phoenix", 39.7);
        System.out.println("Pair 2: " + pair2); // Output: (Phoenix, 39.7)
    }
}
