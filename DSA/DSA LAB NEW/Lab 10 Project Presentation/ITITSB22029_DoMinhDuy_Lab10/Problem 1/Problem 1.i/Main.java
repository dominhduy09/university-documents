// Write a function to convert array to number
// Suppose we have loaded an array with the digits of an integer, where the highest power is kept in position 0, next highest in position 1, and so on. 
// The ones position is always at position array.Length - 1: 
// int[] digits = {2, 0, 1, 8};
// 0*10+x1 then x1 is the first element of the array
// 0*10+x2 then x2 is the second element of the array

public class Main {
    public static int arrayToNumber(int[] digits) {
        int result = 0;
        for (int i = 0; i < digits.length; i++) {
            result = result * 10 + digits[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] digits = { 2, 0, 1, 8 };
        int number = arrayToNumber(digits);
        System.out.println("Number: " + number); // Output: 2018
    }
}