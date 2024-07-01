public class Cat extends Animal {

    public Cat(String name) {
        super(name); // Get the value from Super class
    }

    public void greets() {
        System.out.println("Meow");
    }

    @Override
    public String toString() {
        return "Cat[" + super.toString() + "]";
    }
}
