public class Main {
    public static void main(String[] args) {
        // Declare a variable appointment of type MyPair<MyPair<Integer, Integer>, String>
        MyPair<MyPair<Integer, Integer>, String> appointment;

        // Create a value of type MyPair<MyPair<Integer, Integer>, String> and assign it to appointment
        MyPair<Integer, Integer> time = new MyPair<>(10, 30);
        appointment = new MyPair<>(time, "Meeting");

        // What is the type of appointment.Fst.Snd?
        Class<?> typeOfFstSnd = appointment.Fst.Snd.getClass();
        System.out.println("Type of appointment.Fst.Snd: " + typeOfFstSnd.getName());
    }
}


// The output will show the type of appointment.Fst.Snd, demonstrating that a type-argument may itself be a constructed type.