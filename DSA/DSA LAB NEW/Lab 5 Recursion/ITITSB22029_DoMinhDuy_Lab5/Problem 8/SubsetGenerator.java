import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {
    public static void generateSubsets(List<Integer> current, List<Integer> remaining, List<List<Integer>> result) {
        if (remaining.isEmpty()) {
            result.add(new ArrayList<>(current));
            return;
        }

        generateSubsets(current, remaining.subList(1, remaining.size()), result);

        current.add(remaining.get(0));
        generateSubsets(current, remaining.subList(1, remaining.size()), result);
        current.remove(current.size() - 1); // Backtrack to remove the last added element
    }

    public static void main(String[] args) {
        List<Integer> set = List.of(1, 2, 3); // Input set
        List<List<Integer>> subsets = new ArrayList<>(); // List to store all subsets

        generateSubsets(new ArrayList<>(), set, subsets);

        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
