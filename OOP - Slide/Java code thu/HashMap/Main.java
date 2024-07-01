import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        // Key va gia tri
        HashMap<String, Integer> bangGia = new HashMap<>();
        bangGia.put("Tai", 20000);
        bangGia.put("Tai nam", 25000);
        bangGia.put("Ga", 15000);

        // Them vao khi ko co key trong bangGIa
        bangGia.putIfAbsent("Dac biet", 50000);

        // Map to bao nhieu
        System.out.println(bangGia.size());

        System.out.println(bangGia);

        System.out.println(bangGia.get("Tai"));
        System.out.println(bangGia.values());

        System.out.println(bangGia.keySet());

        for (String pho : bangGia.keySet()) {
            System.out.println(pho + " " + bangGia.get(pho));
        }
        System.out.println(bangGia.containsKey("Gan"));
        System.out.println(bangGia.containsValue(15000));

    }
}