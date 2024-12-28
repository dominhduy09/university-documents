// ShellSortApp.java
// generates an array of 50 random elements
// runs shell sort on the array
// prints value of h and array state at each change of h

class ArraySh {
    private long[] theArray; // ref to array theArray
    private int nElems; // number of data items

    public ArraySh(int max) {
        theArray = new long[max]; // create the array
        nElems = 0; // no items yet
    }

    // Insert element into the array
    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    // Display array contents
    public void display() {
        System.out.print("A=");
        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println();
    }

    // Shell Sort
    public void shellSort() {
        int inner, outer;
        long temp;
        int h = 1;

        // Find initial value of h (1, 4, 13, 40, 121, ...)
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }

        // Outer loop to handle different h values
        while (h > 0) {
            System.out.println("h = " + h); // Print current value of h
            System.out.println("Before:");
            display(); // Display the array before sorting with this h

            // Perform the h-sort
            for (outer = h; outer < nElems; outer++) {
                temp = theArray[outer];
                inner = outer;

                // Inner loop for one subpass (e.g., 0, 4, 8)
                while (inner > h - 1 && theArray[inner - h] >= temp) {
                    System.out.println("\nBefore swap:");
                    display();
                    theArray[inner] = theArray[inner - h]; // Swap
                    inner -= h;
                }
                theArray[inner] = temp;

                System.out.println("After swap: " + inner + " => " + (inner - h));
                display(); // Display after the swap
            }

            System.out.println("After:");
            display(); // Display the array after h-sort
            System.out.println();
            h = (h - 1) / 3; // Decrease h
        }
    }
}

class ShellSortApp {
    public static void main(String[] args) {
        int maxSize = 50; // array size set to 50
        ArraySh arr = new ArraySh(maxSize); // create the array

        // Fill the array with 50 random numbers
        for (int j = 0; j < maxSize; j++) {
            long n = (long) (Math.random() * 100); // generate random number between 0 and 99
            arr.insert(n);
        }

        System.out.println("Unsorted Array:");
        arr.display(); // Display unsorted array

        arr.shellSort(); // Perform shell sort

        System.out.println("Sorted Array:");
        arr.display(); // Display sorted array
    }
}
