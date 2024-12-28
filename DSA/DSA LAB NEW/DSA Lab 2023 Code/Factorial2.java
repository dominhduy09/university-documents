// Computing factorial by recursion

public class Factorial2
{
    public static void main (String[] args) 
    {
        System.out.println (factorial(10));
    }

    static int factorial (int number) 
    {   
        int F;
        System.out.println("Call: factorial("+number+")");
        if (number > 0)
            F = number * factorial(number-1);
        else
            F = 1;
        System.out.println("Exit: factorial("+number+")="+F);
        return F;
    }
}

