public class MyObservable {
    private IObserver[] observers = new IObserver[10];
    private int nObs = 0;

    public void attach(IObserver obs) {
        observers[nObs++] = obs;
    }

    public void myNotify() {
        for (int i = 0; i < nObs; i++) {
            observers[i].update();
        }
    }
}
