public class LineChart implements IObserver {
    private Data data;

    public LineChart(Data data) {
        this.data = data;
        data.attach(this);
    }

    public void draw() {
        System.out.println("LINE CHART");
        System.out.print("A: ");
        for (int i = 0; i < data.getA(); i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.print("B: ");
        for (int i = 0; i < data.getB(); i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.print("C: ");
        for (int i = 0; i < data.getC(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void update() {
        draw();
    }
}
