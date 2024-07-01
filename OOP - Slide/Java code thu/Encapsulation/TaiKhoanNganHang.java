public class TaiKhoanNganHang {
    private double SoDu;

    public void NapTien(double SoTien) {
        if (SoTien <= 0) {
            throw new IllegalArgumentException("So tien nap vao phai lon hon 0");
        }
        SoDu = SoDu + SoTien;
    }

    public void RutTien(double SoTien) {
        if (SoTien > SoDu) {
            throw new IllegalArgumentException("So tien rut vuot qua so du");
        }
        SoDu = SoDu - SoTien;
    }

    public double getSoDu() {
        return SoDu;
    }
}
