public class Main {
    public static void main(String[] args) {
        System.out.print(puzzle(14, 10));
        System.out.print("\n");
        System.out.print(puzzle(4, 7));
        System.out.print("\n");
        System.out.print(puzzle(0, 0));
        System.out.print("\n");
    }

    public static int puzzle(int base, int limit) {
        // base and limit are nonnegative numbers
        if (base > limit) // the base case(s) When base exceeds limit, the function returns -1.
            return -1;
        else if (base == limit) // the base case(s) When base equals limit, the function returns 1.
            return 1;
        else
            return base * puzzle(base + 1, limit); // the recursive case(s)
    }

}
