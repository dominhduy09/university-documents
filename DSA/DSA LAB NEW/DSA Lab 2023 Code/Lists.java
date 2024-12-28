// List processing in LISP, PROLOG and Java

import java.util.ArrayList;

class List
{

//  LISP:
//  (defun member (x y)
//      (cond ((null y) nil)
//      ((eq x (car y)) t)
//      (t (member x (crd y))) ) )

//  PROLOG:
//  member(X,[X]).
//  member(X,[X|T]) :- member(X,T).
    
  public boolean member (int x, ArrayList y)
  {
//      System.out.println ("CALL: member("+ x + "," + y + ")");

//      Create a local copy of y (replace y with z below)
//      ArrayList z = (ArrayList)y.clone(); 
            
      if (y.isEmpty()) return false;
      else if (x == y.get(0)) return true;
      else { 
          boolean result;
          y.remove(0);
          result = member(x,y);
//          System.out.println ("EXIT: member("+ x + "," + y + ")");
          return result;
       }
  }
  
//  LISP:
//  (defun (append x y) 
//       (cond ( (null x) y) 
//           (t (cons (car x) (append (cdr x) y)))))

//  PROLOG:
//  append([],L,L).
//  append([X|T],L,[X|V]) :- append(T,L,V).
 
  public ArrayList append (ArrayList x, ArrayList y)
  {
      System.out.println ("CALL: append("+ x + "," + y + ")");
      
      ArrayList z = (ArrayList)x.clone(); // create a local copy of x

      if (x.isEmpty()) return y;
      else
      {   
          ArrayList result;
          Integer t = (Integer)z.remove(0);
          result = append(z,y);
          result.add(0,t);
          System.out.println ("EXIT: append("+ x +"," + y + ")");
          return result;
      }
   }

//  PROLOG:
//  reverse([X|Y],Z,W) :- reverse(Y,[X|Z],W).
//  reverse([],X,X).

  public ArrayList reverse (ArrayList x)
  {
      System.out.println ("reverse("+ x +")");

      if (x.isEmpty()) return x;
      else 
      {
           Integer t = (Integer)x.remove(0);
           reverse(x).add(t);
           System.out.println ("reverse("+ x +")");
           return x;
       }
  }
}

public class Lists
{
   public static void main (String[] args)
   {
      ArrayList list1 = new ArrayList();
      for (int i=1; i<=5; i++) list1.add(i);
      
      ArrayList list2 = new ArrayList();
      for (int i=6; i<=9; i++) list2.add(i);

      List l = new List();
//      System.out.println (l.member(4,list1));
      System.out.println (l.append(list1,list2));
      System.out.println (l.reverse(list1));

   }
}

