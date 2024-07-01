public class Main {
    public static void main(String[] args) {
        MyList<Integer> intList = new MyList<>();
        intList.add(1);
        intList.add(2);

        MyList<Double> doubleList = new MyList<>();
        doubleList.add(3.14);
        doubleList.add(2.718);

        // Usage examples:
        intList.remove(1);
        doubleList.remove(3.14);

    }
}
