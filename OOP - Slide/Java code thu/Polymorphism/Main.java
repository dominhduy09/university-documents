class Main {
    public static void main(String[] args) {
        NhanVien nhanVienThuong = new NhanVienThuong();
        NhanVien nhanVienVanPhong = new NhanVienVanPhong();

        nhanVienThuong.TinhLuong();
        nhanVienVanPhong.TinhLuong();
        // Or

        keToan(nhanVienThuong);
        keToan(nhanVienVanPhong);
    }

    static void keToan(NhanVien nhanVien) {
        nhanVien.TinhLuong();
    }
}

class NhanVien {
    public void TinhLuong() {
        System.out.println("Dang tinh luong nhan vien");
    }
}

class NhanVienThuong extends NhanVien {
    @Override
    public void TinhLuong() {
        System.out.println("Dang tinh luong nhan vien thuong");
    }
}

class NhanVienVanPhong extends NhanVien {
    @Override
    public void TinhLuong() {
        System.out.println("Dang tinh luong nhan vien van phong ");
    }
}