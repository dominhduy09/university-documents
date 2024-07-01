class Animal {
    String color = "White";
}

class Dog extends Animal {
    String color = "Black";

    void printColor() {
        System.out.println(color); // Black
        System.out.println(super.color); // White

    }

}

class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.printColor();
    }
}