// Ngoai le rieng
class TenTrongKhongException extends RuntimeException {
    public TenTrongKhongException(String thongDiep) {
        super(thongDiep);
    }
}

class Main {

    public static void doDaiString(String tenChuoi) throws NullPointerException, TenTrongKhongException {
        if (tenChuoi == null) {
            throw new NullPointerException("Ten nhap vao khong duoc la null");
        }
        System.out.println("Do dai cua String la: " + tenChuoi.length());
    }

    public static void main(String[] args) {
        String tenRapper = null;
        doDaiString(tenRapper);
    }
}