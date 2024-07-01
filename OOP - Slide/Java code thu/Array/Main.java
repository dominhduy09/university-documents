class Main {
    public static void main(String[] args) {
        String[] danhSachHocSinh = { "tom", "teo" }; // Khong the thay doi do dai cua mang

        // danhSachHocSinh[0] = "Lan";
        // System.out.println(danhSachHocSinh[0]);

        int[] diemHocSinh = new int[5];
        diemHocSinh[0] = 10;

        // dung length boi vi no la mang Array
        for (int i = 0; i < diemHocSinh.length; i++) {
            System.out.println(diemHocSinh[i]);
        }
    }
}

// Tom lai:
// Mang la cong cu tien loi dung de luu nhieu gia tri co cung kieu du lieu trong
// 1 bien duy nhat
// Mang co do dai co dinh sau khi khoi tao
// Chi so cua Mang bat dau tu 0 cho den do dai cua Mang - 1
// Dung vong lap de lap qua cac phan tu cua Mang 1 cach nhanh chong