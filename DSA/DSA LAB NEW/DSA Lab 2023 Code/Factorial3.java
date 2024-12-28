// Computing factorial by simulating recursion using a stack

class StackX
   {
   private int maxSize;        // size of stack array
   private int[] stackArray;
   private int top;            // top of stack
//--------------------------------------------------------------
   public StackX(int s)        // constructor
      {
      maxSize = s;
      stackArray = new int[maxSize];
      top = -1;
      }
//--------------------------------------------------------------
   public void push(int p)     // put item on top of stack
      { stackArray[++top] = p; }
//--------------------------------------------------------------
   public int pop()            // take item from top of stack
      { return stackArray[top--]; }
//--------------------------------------------------------------
   public int peek()           // peek at top of stack
      { return stackArray[top]; }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if stack is empty
      { return (top == -1); }
      
   public String toString()
   {   
       if (top == -1) return "[]";
       else
       {   
           String S = "[";
           for (int i=top;i>0;i--) S = S + stackArray[i] + ",";
           S = S + stackArray[0] + "]";
           return S;
       }
   }
//--------------------------------------------------------------
}  // end class StackX

public class Factorial3
{
   static int N;
   static int F;
   static StackX Stack;

   public static void main (String[] args) 
    {
        System.out.println (factorial(10));
    }

   static int factorial (int number) 
   {
       Stack = new StackX(1000);    // make a stack
       N = number;
       F = 1;                       // initialize F

       System.out.println(Stack);
       while(N > 0)
       {
           Stack.push(N);           // push value
           N = N-1;                 // decrement value
           System.out.println(Stack);
       }
       while( !Stack.isEmpty() )    // until stack empty,
       {
           System.out.println(Stack+" "+F);
           int newN = Stack.pop();  // pop value,
           F = F*newN;              // multiply with answer
       }
       System.out.println(Stack);
       return F;   
   }
}
