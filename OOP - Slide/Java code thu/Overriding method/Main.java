class Main {
    public static void main(String[] args) {
        NhanVat NhanVatBinhThuong = new NhanVat();
        CaiBang NhanVatCaiBang = new CaiBang();

        NhanVatBinhThuong.tanCong();
        NhanVatCaiBang.tanCong();

    }
}

class NhanVat {
    public void tanCong() {
        System.out.println("Tan cong bang tay");
    }
}

class CaiBang extends NhanVat {
    @Override
    public void tanCong() {
        System.out.println("Thien long giang chuong");
    }
}

// 5 Luật Bạn Phải Biết | Code Thu

// 1. Ten phuong thuc, kieu du lieu trong phuong thuc ghi de phai giong 100%
// phuong thuc bi ghi de

// 2. Kieu du lieu tra ve cua phuong thuc ghi de phai giong 100% phuong thuc bi
// ghi de

// 3. Phai co 1 moi quan he ke thua giua cac lop co lien quan

// 4. Kha nang truy cap cua phuong thuc ghi de khong duoc han che hon phuong
// thuc bi ghi de

// 5. Khong the ghi de len phuong thuc duoc dinh nghia la final-static
// --> final la phuong thuc trien khai cuoi cung va khong the thay doi boi cac
// lop con
// --> static la thuoc ve lop chu khong thuoc ve mot doi tuong nao ca

// Luon luon dung Annotation Override dung de danh dau no la phuong thuc ghi de