public class Main {
    public static void main(String[] args) {
        MyPair<Integer, String> pair = new MyPair<>(42, "Hello");
        MyPair<String, Integer> swappedPair = pair.swap();
        System.out.println("Original pair: " + pair); // Output: (42, Hello)
        System.out.println("Swapped pair: " + swappedPair); // Output: (Hello, 42)

    }
}
