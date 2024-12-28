import java.io.*;

class DataItem {
    private int iData;

    public DataItem(int ii) {
        iData = ii;
    }

    public int getKey() {
        return iData;
    }
}

class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;
    private int totalProbes;
    private int insertCount;

    HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
        totalProbes = 0;
        insertCount = 0;
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null && hashArray[j].getKey() != -1)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }

    public int hashFunc1(int key) {
        return key % arraySize;
    }

    public int hashFunc2(int key) {
        return 5 - key % 5;
    }

    public void insert(int key, DataItem item) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        int probeCount = 0;

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
            probeCount++;
        }
        hashArray[hashVal] = item;
        probeCount++;
        totalProbes += probeCount;
        insertCount++;

        System.out.println("Inserted key " + key + " with hash value " + hashVal +
                ", step size " + stepSize + ", probe count " + probeCount);
    }

    public DataItem find(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        int probeCount = 0;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                probeCount++;
                System.out.println("Found key " + key + " at hash value " + hashVal +
                        ", step size " + stepSize + ", probe count " + probeCount);
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
            probeCount++;
        }
        System.out.println("Key " + key + " not found after " + probeCount + " probes.");
        return null;
    }

    public void calculateAverageProbeLength() {
        if (insertCount > 0) {
            double average = (double) totalProbes / insertCount;
            System.out.println("Average probe length: " + average);
        }
    }
}

class HashDoubleApp {
    public static void main(String[] args) throws IOException {
        int aKey;
        DataItem aDataItem;
        int size, n;

        System.out.print("Enter size of hash table (preferably a prime number): ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();

        HashTable theHashTable = new HashTable(size);

        System.out.println("Initial Key Sequence:");
        for (int j = 0; j < n; j++) {
            aKey = (int) (Math.random() * 2 * size);
            aDataItem = new DataItem(aKey);
            System.out.print(aKey + " ");
            theHashTable.insert(aKey, aDataItem);
        }
        System.out.println();

        theHashTable.calculateAverageProbeLength();

        while (true) {
            System.out.print("Enter first letter of show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insert(aKey, aDataItem);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    theHashTable.find(aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static char getChar() throws IOException {
        return getString().charAt(0);
    }

    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}
