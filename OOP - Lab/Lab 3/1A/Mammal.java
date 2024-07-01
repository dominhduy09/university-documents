public class Mammal extends Animal {

    public Mammal(String name) {
        super(name); // Get the value from Super class
    }

    @Override
    public String toString() {
        return "Mammal[" + super.toString() + "]"; // Get the value from Super class
    }
}