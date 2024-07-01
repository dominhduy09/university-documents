public class BarChart implements IObserver {

    private Data data;

    public BarChart(Data data) {
        this.data = data;
        data.attach(this);
    }

    public void drawBarChart() {
        System.out.println("THE BAR CHART");
        System.out.print("A: ");
        for (int i = 0; i < data.getA(); i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("B: ");
        for (int i = 0; i < data.getB(); i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("C: ");
        for (int i = 0; i < data.getC(); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void setA(int a) {
        data.setA(a);
    }

    @Override
    public void update() {
        drawBarChart();
    }

}
