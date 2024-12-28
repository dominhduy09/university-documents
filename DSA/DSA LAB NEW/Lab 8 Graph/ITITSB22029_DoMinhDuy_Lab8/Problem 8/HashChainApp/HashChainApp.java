import java.io.*;

////////////////////////////////////////////////////////////////
class Link { // (could be other items)
    private int iData; // data item
    public Link next; // next link in list

    public Link(int it) // constructor
    {
        iData = it;
    }

    public int getKey() {
        return iData;
    }

    public void displayLink() // display this link
    {
        System.out.print(iData + " ");
    }
}
////////////////////////////////////////////////////////////////

class SortedList {
    private Link first; // ref to first list item

    public SortedList() // constructor
    {
        first = null;
    }

    public int insert(Link theLink) // insert link, in order
    {
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;
        int probeCount = 1; // Start counting probes

        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
            probeCount++; // Increment probe count
        }

        if (previous == null)
            first = theLink; // Insert at beginning
        else
            previous.next = theLink;

        theLink.next = current;
        return probeCount; // Return number of probes
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.next;
        }

        if (previous == null)
            first = first.next;
        else
            previous.next = current.next;
    }

    public Link find(int key) {
        Link current = first;
        int probeCount = 0;

        while (current != null && current.getKey() <= key) {
            probeCount++;
            if (current.getKey() == key) {
                System.out.println("Probes for finding key " + key + ": " + probeCount);
                return current;
            }
            current = current.next;
        }

        System.out.println("Probes for finding key " + key + ": " + probeCount);
        return null;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;

        while (current != null) {
            current.displayLink();
            current = current.next;
        }

        System.out.println("");
    }
}
////////////////////////////////////////////////////////////////

class HashTable {
    private SortedList[] hashArray;
    private int arraySize;
    private int totalProbes; // Track total probes for inserts
    private int numInserts; // Track number of inserts

    public HashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new SortedList();
        }
        totalProbes = 0;
        numInserts = 0;
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        int probeCount = hashArray[hashVal].insert(theLink); // Insert and get probes
        totalProbes += probeCount;
        numInserts++;
        System.out.println("Inserted key: " + key + ", Probes: " + probeCount);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        return hashArray[hashVal].find(key);
    }

    public double getAverageProbes() {
        return numInserts > 0 ? (double) totalProbes / numInserts : 0.0;
    }
}
////////////////////////////////////////////////////////////////

class HashChainApp {
    public static void main(String[] args) throws IOException {
        int aKey;
        Link aDataItem;
        int size, n, keysPerCell = 100;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();

        HashTable theHashTable = new HashTable(size);

        System.out.println("Keys inserted during initial filling:");
        for (int j = 0; j < n; j++) {
            aKey = (int) (Math.random() * keysPerCell * size);
            aDataItem = new Link(aKey);
            System.out.print(aKey + " ");
            theHashTable.insert(aDataItem);
        }
        System.out.println();

        double loadFactor = (double) n / size;
        double avgProbes = theHashTable.getAverageProbes();
        System.out.println("Load Factor: " + loadFactor);
        System.out.println("Average Probe Length: " + avgProbes);

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
                    aDataItem = new Link(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null)
                        System.out.println("Found " + aKey);
                    else
                        System.out.println("Could not find " + aKey);
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
