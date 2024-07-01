public class phepToan {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(int a) {
        return a;
    }

    public static int sum() {
        return 0;
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(sum(23, 45));
        System.out.println(sum(12));
        System.out.println(sum());
        System.out.println(sum(23.4, 23.6));
    }
}

// method signature --> different parameter