import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {

        // Theo thu tu
        List<String> tenList = new ArrayList<>();
        tenList.add("Tien");
        tenList.add("Tam");
        tenList.add("Tai");
        // Cho phep them trung lap
        tenList.add("Tien");
        System.out.println(tenList);
        tenList.get(0);

        // Ko theo thu tu
        Set<String> tenSet = new HashSet<>();
        tenSet.add("Tien");
        tenSet.add("Tam");
        tenSet.add("Tai");
        // Khong bi trung lap
        tenSet.add("Tien");
        System.out.println(tenSet);
        // remove
        // contains
        // size
        // tenset.isEmpty

        // Su dung method reference
        tenSet.forEach(System.out::println);

        // Su dung lambda
        tenSet.forEach(ten -> System.out.println(ten));

        // Dai dong lang nhang
        for (String ten : tenSet) {
            System.out.println(ten);
        }

        Iterator<String> i = tenSet.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        // Dam bao duy tri thu tu
        Set<String> tenSec = new LinkedHashSet<>();
        tenSec.add("Tien");
        tenSec.add("Tam");
        tenSec.add("Tai");
        System.out.println(tenSec);

        // Sap xep cac phan tu theo thu tu tang dan
        Set<String> tenSex = new TreeSet<>();
        tenSex.add("Tien");
        tenSex.add("Tam");
        tenSex.add("Tai");
        System.out.println(tenSex);
    }
}