// towers.java
// solves Towers of Hanoi puzzle
// to run this program: C>java TowersApp
////////////////////////////////////////////////////////////////
class TowersApp {
    static int nDisks = 10;
    static int stepCount = 0; // Counter for recursive steps

    public static void main(String[] args) {
        doTowers(nDisks, 'A', 'B', 'C');
        System.out.println("Total recursive steps: " + stepCount);
    }

    // -----------------------------------------------------------
    public static void doTowers(int topN, char src, char inter, char dest) {
        stepCount++; // Increment the counter for each call
        if (topN == 1) {
            System.out.println("Disk 1 from " + src + " to " + dest);
        } else {
            doTowers(topN - 1, src, dest, inter); // src to inter
            System.out.println("Disk " + topN + " from " + src + " to " + dest); // move bottom
            doTowers(topN - 1, inter, src, dest); // inter to dest
        }
    }
    // -------------------------------------------------------------
} // end class TowersApp
  ////////////////////////////////////////////////////////////////
