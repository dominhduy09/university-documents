class Main {
    public static void main(String[] args) {
        TaiKhoanNganHang TaiKhoanCuaDuy = new TaiKhoanNganHang();
        TaiKhoanCuaDuy.NapTien(100000);
        TaiKhoanCuaDuy.RutTien(50000);
        System.out.println(TaiKhoanCuaDuy.getSoDu());
    }
}