import java.util.ArrayList;
import java.util.List;

class MyList<T> {
    private List<T> values;

    public MyList() {
        this.values = new ArrayList<>();
    }

    public void add(T value) {
        values.add(value);
    }

    public void remove(T value) {
        values.remove(value);
    }
}
