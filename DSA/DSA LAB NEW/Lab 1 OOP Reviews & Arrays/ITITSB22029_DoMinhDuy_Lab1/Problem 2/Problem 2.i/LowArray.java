// LowArray.java
// demonstrates array class with low-level interface
/////
class LowArray {
    private long[] a; // Refer to array a

    public LowArray(int size) {
        a = new long[size]; // Create array
    }

    public void setElem(int index, long value) {
        a[index] = value; // Setter
    }

    public long getElem(int index) {
        return a[index]; // Getter
    }

    public static void main(String[] args) {
        LowArray arr;
        arr = new LowArray(100);
        int nElems = 0;
        int j;

        arr.setElem(0, 77); // insert 10 items
        arr.setElem(1, 99);
        arr.setElem(2, 44);
        arr.setElem(3, 55);
        arr.setElem(4, 22);
        arr.setElem(5, 88);
        arr.setElem(6, 11);
        arr.setElem(7, 00);
        arr.setElem(8, 66);
        arr.setElem(9, 33);
        nElems = 10;

        for (j = 0; j < nElems; j++) {
            System.err.println(arr.getElem(j) + " ");
        }
        System.out.println("");

        // Find and display
        int searchKey = 26;
        for (j = 0; j < nElems; j++) {
            if (arr.getElem(j) == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            System.out.println("Can not find " + searchKey);
        } else {
            System.out.println("Found" + searchKey);
        }

        // Delete 55
        for (j = 0; j < nElems; j++) {
            if (arr.getElem(j) == 55) {
                break;
            }
        }

        for (int k = j; k < nElems; k++) {
            arr.setElem(k, arr.getElem(k + 1));
        }
        nElems--;

        for (j = 0; j < nElems; j++) {
            System.out.println(arr.getElem(j) + " ");
        }
        System.out.println("");
    }
}