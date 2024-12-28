// create an array of integers and sort it using bubble sort algorithm and print the sorted array.

public class BubbleSort {

    public static void main(String[] args) {
        int[] int_array = { 5, 2, 7, 9, 41, 35, 66, 76, 47, 34 };
        BubbleSort(int_array);
        System.out.println(java.util.Arrays.toString(int_array));

    }

    public static void BubbleSort(int[] int_array) {
        int nElems = int_array.length;
        int in;
        int out;
        int temp;

        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (int_array[in] > int_array[in + 1]) {
                    temp = int_array[in];
                    int_array[in] = int_array[in + 1];
                    int_array[in + 1] = temp;

                }
            }
        }
    }
}