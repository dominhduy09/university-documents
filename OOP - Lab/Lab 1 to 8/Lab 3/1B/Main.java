public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("chihuahua");
        Dog dog2 = new Dog("corgi");
        BigDog dog3 = new BigDog("Hulk");

        Cat cat1 = new Cat("heasti");

        dog1.greets();
        dog1.greets(dog2);
        System.out.println(dog1.toString());

        cat1.greets();
        System.out.println(cat1.toString());

        dog3.greets(dog2);
        dog3.greets(dog1);
        dog3.greets(dog3);
        dog3.greets();

    }
}
