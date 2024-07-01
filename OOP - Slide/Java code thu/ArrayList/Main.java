import java.util.ArrayList;

// Mang thi dung length
// ArrayList thi dung size

class Main {
    public static void main(String[] args) {
        ArrayList<String> gioHangArrayList = new ArrayList<>(); // khong duoc dung kieu du lieu nguyen thuy
        // THem phan tu using add
        gioHangArrayList.add("Chuối");
        gioHangArrayList.add("Thịt");
        gioHangArrayList.add("Cam");

        // Phuong thuc set gom (Chi so, gia tri)
        gioHangArrayList.set(0, "Hanh");

        // Remove dung de xoa 1 phan tu (Chi so) Hoac (Gia tri)
        gioHangArrayList.remove(2);
        gioHangArrayList.remove("Hanh");

        // Contains de kiem tra gia tri do co o trong ArrayList hay ko
        System.out.println(gioHangArrayList.contains("Shit"));

        // Clear de xoa toan bo gio hang
        gioHangArrayList.clear();

        for (int i = 0; i < gioHangArrayList.size(); i++) {
            System.out.println(gioHangArrayList.get(i));
        }
    }
}