// The Farmer, Wolf, Goat and Cabbage problem
// Illustrates recursive state space search

/*
change_state(s,W,G,C,n,W,G,C).
change_state(n,W,G,C,s,W,G,C).
change_state(s,s,G,C,n,n,G,C).
change_state(n,n,G,C,s,s,G,C).
change_state(s,W,s,C,n,W,n,C).
change_state(n,W,n,C,s,W,s,C).
change_state(s,W,G,s,n,W,G,n).
change_state(n,W,G,n,s,W,G,s).

illegal(s,n,n,_).
illegal(n,s,s,_).
illegal(s,_,n,n).
illegal(n,_,s,s).
*/

import java.util.ArrayList;

class State 
{
   boolean B,W,G,C;  // n (north) and s (south) are represented by true and false
   
   public State (boolean B1,boolean W1,boolean G1,boolean C1)
   {
       B = B1;
       W = W1;
       G = G1;
       C = C1;
   }
   
   public boolean eq (boolean B1,boolean W1,boolean G1,boolean C1)
   {
       if (B==B1 & W==W1 & G==G1 & C==C1) return true;
       else return false;
   }

   public void printSt ()
   {
       System.out.println(B+"\t"+W+"\t"+G+"\t"+C);
   }
}

public class Farmer
{
    static ArrayList<State>path = new ArrayList<State>();
    public static void main (String[] args)
    {
        solve(false,false,false,false);
        System.out.println("FARMER\tWOLF\tGOAT\tCABBAGE");
        for (int i = 0; i < path.size(); i++) path.get(i).printSt();
    }

    public static boolean solve(boolean B,boolean W,boolean G,boolean C) 
    {
        boolean done = false;
        if (B & W & G & C) {path.add(new State(B,W,G,C)); return true;}
        else if (illegal(B,W,G,C)) return false;
        else if (visited(B,W,G,C)) return false;
        else 
        { 
            path.add(new State(B,W,G,C));
            if (!done & B) done = solve(false,W,G,C);
            if (!done & !B) done = solve(true, W,G,C);
            if (!done & B & W) done = solve(false,false,G,C);
            if (!done & !B & !W) done = solve(true,true,G,C);
            if (!done & B & G) done = solve(false,W,false,C);
            if (!done & !B & !G) done = solve(true,W,true,C);
            if (!done & B & C) done = solve(false,W,G,false);
            if (!done & !B & !C) done = solve(true,W,G,true);
            return done;
        }
    }
    
    public static boolean illegal(boolean B,boolean W,boolean G,boolean C) 
    {
        if (B & !W & !G ) return true;
        if (!B & W & G ) return true;
        if (B & !G & !C ) return true;
        if (!B & G & C ) return true;
        return false;
    }
    
    public static boolean visited(boolean B,boolean W,boolean G,boolean C) 
    {
        boolean ok = false;
        for (int i = 0; i < path.size(); i++) if (path.get(i).eq(B,W,G,C)) ok=true;
        return ok;
    }

}
