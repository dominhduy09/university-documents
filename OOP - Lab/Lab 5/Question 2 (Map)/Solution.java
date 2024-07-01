
//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine(); // this is to clear the buffer

        HashMap<String, Integer> phonebook = new HashMap<String, Integer>(n);

        // read in all the names and phones number
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine(); // this is to clear the buffer

            phonebook.put(name, phone);
        }

        // this section is where the queries of the names show up
        while (in.hasNext()) { // this is to check if there is a next line in the input stream
            String s = in.nextLine();

            Integer phonenumber = phonebook.get(s);

            if (phonenumber == null) {
                System.out.println("Not found");
            }

            else {
                System.out.println(s + "=" + Integer.toString(phonenumber));
            }

        }
    }
}