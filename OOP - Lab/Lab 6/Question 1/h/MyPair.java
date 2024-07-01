public class MyPair<T, U> {
    public final T Fst;
    public final U Snd;
    
    public MyPair(T fst, U snd) {
        this.Fst = fst;
        this.Snd = snd;
    }
    
    public MyPair<U, T> swap() {
        return new MyPair<>(Snd, Fst);
    }
    
    public String toString() {
        return "(" + Fst + ", " + Snd + ")";
    }
}
