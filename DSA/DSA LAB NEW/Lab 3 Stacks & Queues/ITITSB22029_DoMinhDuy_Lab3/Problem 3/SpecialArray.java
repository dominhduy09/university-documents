
// an array of 20 random values 
// a function to update the value at a position in the array. 
// a function to undo the updating. 
// a function to redo the updating. 
// a function to display content of the array. 
// Hint: use two stacks to store the array after each operation 
import java.util.Stack;

public class SpecialArray {
    private int[] array = new int[20]; // array of 20 random values
    private Stack<int[]> undoStack = new Stack<int[]>();
    private Stack<int[]> redoStack = new Stack<int[]>();

    public SpecialArray() { // constructor
        for (int i = 0; i < 20; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    public void update(int index, int value) {
        undoStack.push(array.clone());
        array[index] = value;
    }

    public void undo() {
        redoStack.push(array.clone());
        array = undoStack.pop();
    }

    public void redo() {
        undoStack.push(array.clone());
        array = redoStack.pop();
    }

    public void display() {
        for (int i = 0; i < 20; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SpecialArray sa = new SpecialArray();
        sa.display();
        sa.update(3, 100);
        sa.display();
        sa.undo();
        sa.display();
        sa.redo();
        sa.display();
    }
}
