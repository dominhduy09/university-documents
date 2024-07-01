public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("chihuahua");
        Dog dog2 = new Dog("corgi");
        Cat cat1 = new Cat("heasti");

        dog1.greets();
        dog1.greets(dog2);
        System.out.println(dog1.toString());

        cat1.greets();
        System.out.println(cat1.toString());

    }
}
