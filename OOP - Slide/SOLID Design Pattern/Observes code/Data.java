public class Data extends MyObservable {
    private int a;
    private int b;
    private int c;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public void setA(int a) {
        this.a = a;
        myNotify();
    }

    public void setB(int b) {
        this.b = b;
        myNotify();
    }

    public void setC(int c) {
        this.c = c;
        myNotify();
    }

}
