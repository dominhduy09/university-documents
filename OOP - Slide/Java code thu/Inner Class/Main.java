public class Main {
    public static void main(String[] args) {
        BenNgoai benNgoai = new BenNgoai();

        BenNgoai.BenTrong benTrong = benNgoai.new BenTrong();
        // BenNgoai.BenTrong benTrong = new BenNgoai.BenTrong();

        benTrong.phuongThucBenTrong();
        System.out.println(benTrong.chaoTuBenTrong);
    }
}
