import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        
    
        Scanner input = new Scanner(System.in);
        int User = input.nextInt();
        
        int i;
        int n = 10;
        
        for (i = 1 ; i <= n ; i++) {
            int result = User * i;
            System.out.println(User + " x " + i + " = " + result  );
        }
    }
}
1