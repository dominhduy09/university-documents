/**
 * Main
 */
public class Main {

    public static <T> void printer(T value) {
        System.out.println(value);
    }

    public static void main(String[] args) {
        printer(123);
        printer("okokoks");
    }
}