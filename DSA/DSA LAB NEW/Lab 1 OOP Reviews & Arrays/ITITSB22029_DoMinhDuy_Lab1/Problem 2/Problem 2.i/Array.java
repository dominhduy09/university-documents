// Array.java
// demonstrates Java arrays
/////
class Array {
    public static void main(String[] args) {
        long[] arr; // Refer to array
        arr = new long[100]; // Make array

        int nElems = 0; // Number of items
        int j;
        int k;
        long searchKey;

        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 00;
        arr[8] = 66;
        arr[9] = 33;
        nElems = 10;

        for (j = 0; j < nElems; j++) {
            System.out.println(arr[j] + " ");
        }
        System.out.println("");

        // Find and display
        searchKey = 66;
        for (j = 0; j < nElems; j++) {
            if (arr[j] == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            System.out.println("Can not find " + searchKey);
        } else {
            System.out.println("Found " + searchKey);
        }

        // Find and delete
        searchKey = 55;
        for (j = 0; j < nElems; j++) {
            if (arr[j] == searchKey) {
                break;
            }
        }
        for (k = j; k < nElems - 1; k++) {
            arr[k] = arr[k + 1];
        }
        nElems--;

        for (j = 0; j < nElems; j++) {
            System.out.println(arr[j] + " ");

        }
        System.out.println("");
    }
}