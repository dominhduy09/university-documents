public static int gemstones(List<String> arr) {
    // Write your code here
        int cache[] = new int[256];
        int counter = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).length(); j++) {
                int tmp = (int) arr.get(i).charAt(j);
                if (cache[tmp] == i) {
                    cache[tmp]++;
                }

                if (cache[tmp] == arr.size()) {
                    cache[tmp]++;
                    counter++;
                }
            }
        }

        return counter;
    }