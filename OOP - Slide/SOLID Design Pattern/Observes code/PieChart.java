public class PieChart implements IObserver {

    private Data data;

    public PieChart(Data data) {
        this.data = data;
        data.attach(this);
    }

    public void draw() {
        System.out.println("THE PIE CHART");
        System.out.println(data.getA());
        System.out.println(data.getB());
        System.out.println(data.getC());
    }

    @Override
    public void update() {
        draw();
    }

}
