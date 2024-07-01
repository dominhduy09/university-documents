enum PizzaStatus {
    DAT_HANG(5),
    CHUAN_BI(15),
    GIAO_HANG(10);

    final int thoiGian; // Them truong thi phai tao them constructor

    PizzaStatus(int thoiGian) {
        this.thoiGian = thoiGian;
    }

}

public class Main {

    public static void main(String[] args) {
        PizzaStatus status = PizzaStatus.DAT_HANG;
        if (status == PizzaStatus.DAT_HANG) {
            System.out.println("Pizza da duoc dat hang ");
        }

        for (PizzaStatus s : PizzaStatus.values()) {
            System.out.println(s);
        }

        System.out.println(PizzaStatus.GIAO_HANG.thoiGian);
    }
}