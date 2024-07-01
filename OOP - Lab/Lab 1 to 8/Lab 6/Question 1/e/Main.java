public class Main {
    public static void main(String[] args) {
        // Declare a variable grades of type MyPair<String, Integer>[]
        MyPair<String, Integer>[] grades;

        // Create an array of length 5 with element type MyPair<String, Integer>
        grades = new MyPair[5];

        // Create some MyPair instances
        MyPair<String, Integer> pair1 = new MyPair<>("Alice", 85);
        MyPair<String, Integer> pair2 = new MyPair<>("Bob", 90);
        MyPair<String, Integer> pair3 = new MyPair<>("Charlie", 75);

        // Store the MyPair instances into grades[0], grades[1], and grades[2]
        grades[0] = pair1;
        grades[1] = pair2;
        grades[2] = pair3;
    }
}
