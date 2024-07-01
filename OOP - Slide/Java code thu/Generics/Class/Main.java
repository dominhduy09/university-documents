class Main {
    public static <T> void printer(T value) {
        System.out.println(value);
    }

    public static void main(String[] args) {
        Person<Integer, Integer> person1 = new Person<>(1, 20);
        System.out.println("Thong tin person1: " + person1.getId() + " " + person1.getAge());

        Person<Double, String> personDouble = new Person<Double, String>(2.5, "daylachuoi");
        System.out.println("Thong tin personDouble: " + personDouble.getId() + " " + personDouble.getAge());

        Person<Integer, Double> personString = new Person<Integer, Double>(12, 4.3);
        System.out.println("Thong tin personString: " + personString.getId() + " " + personString.getAge());

        printer(123123);
        printer("caijvaodaycungdc");
    }
}