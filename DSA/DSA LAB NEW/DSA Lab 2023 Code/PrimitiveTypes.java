// Illustrates primitive types, operations, conversion, overflow, boolean expesssions

class PrimitiveTypes
{
   public static void main (String[] args) {
       int a;
       a = 17;
       int b = 5;
       double y;
       y = 5;
       
       // Casting and promotion
       System.out.println (a + "/" + b + " = " + (double)(a / b));
       System.out.println (a + "/" + b + " = " + ((double)a / b));
       System.out.println (a + "/" + y + " = " + (a / y));

       // Overflow
       int z = 2147483647;
       System.out.println (z + " + 1 = " + (z+1));
       z++; // z = z + 1;
       System.out.println (z);

       // Boolean variables
       System.out.println (a + " > " + b + " = " + (a > b));
       boolean result;
       result = a > b;
       System.out.println (a + " > " + b + " = " + result);
       a = 10;
       b = 10;
       System.out.println (a + " > " + b + " = " + (a > b));
       
   }

}

