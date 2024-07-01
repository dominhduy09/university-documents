public class A {
    public A() {
      System.out.println("Ctor of A");
    }
  }
  
  public class B extends A {
    public B() {
      System.out.println("Ctor of B");
    }
  }
  
  public class C extends B{
    public C() {
      System.out.println("Ctor of C");
    }
  
    public static void main(String[] args) {
      C c = new C();
    }
  }
  