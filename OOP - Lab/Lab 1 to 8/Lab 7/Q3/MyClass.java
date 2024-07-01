public class MyClass {
    public static void main(String[] args) { // main method
        int myArray[] = new int[7]; // luon dung 7 phan tu

        try {
            System.out.println(myArray[9]); // truy cap vao phan tu thu 9 nhung chi co 7 phan tu nen se bi loi

        } catch (ArrayIndexOutOfBoundsException aiofbe) { // bat loi ArrayIndexOutOfBoundsException
            // TODO: handle exception
            System.out.println("The element 9 does not exist!");

        }
    }
}