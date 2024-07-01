interface DongVatCaSi {
    void hat();

    void noi();
}

class HoaMi extends DongVat implements DongVatCaSi {

    @Override
    public void hat() {
        // TODO Auto-generated method stub
        System.out.println("Liu Lo");
    }

    @Override
    public void noi() {
        // TODO Auto-generated method stub
        System.out.println("La la 0 la la");

    }

}

abstract class DongVat { // Khong duoc khoi tao lop Abstract

    // Day la phuong thuc truu tuong vi no ko co body
    public abstract void noi();

    public void ngu() {
        System.out.println("Dong vat dang ngu"); // Phuong thuc cu the vi no co body
    }
}

// Phai can mot lop khong phai Abstract class de noi rong
class Meo extends DongVat {
    @Override // Annotation OVerride nay chi cho java biet rang cai phuong thuc nay la phuong
              // thuc ghi de len mot phuong thuc duoc khai bao o trong lop cha

    // Trong version moi thi ko can

    public void noi() { // khong du tu khoa abstract
        System.out.println("Meo meoww");
    }

}

public class Main {

    public static void main(String[] args) {
        DongVat dongvat = new Meo();
        dongvat.ngu();
        dongvat.noi();

        DongVatCaSi hoami = new HoaMi();
        hoami.hat();
        hoami.noi();

    }
}