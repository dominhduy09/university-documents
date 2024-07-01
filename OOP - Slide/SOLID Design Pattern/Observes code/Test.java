public class Test {
    public static void main(String[] args) {
        Data data = new Data();
        data.setA(10);
        data.setB(5);
        data.setC(20);

        BarChart bar = new BarChart(data);
        PieChart pieChart = new PieChart(data);
        LineChart line = new LineChart(data);

        bar.drawBarChart();
        pieChart.draw();

        System.out.println("--------------------------");

        bar.setA(40);

    }
}
