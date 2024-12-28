// Computing factorial by simple iteration

public class Factorial1
{
    public static void main (String[] args) 
    {
        System.out.println (fact(10));
    }

    public static int fact (int number) 
    {
        int F = 1;
        for (int i = 1; i<=number; i++)
            F = F * i;
        return F;
   }
}
