// B - Spiral Tap
/////

import java.util.Scanner;

public class SpiralTap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int SZ = sc.nextInt(); // Size of the grid (odd number)
            int P = sc.nextInt(); // Spiral position of a cell

            if (SZ == 0 && P == 0)
                break; // End of input condition

            int center = (SZ + 1) / 2; // Center of the grid (both X and Y coordinates)

            int x = center, y = center;
            if (P != 1) {
                int ring = (int) Math.ceil((Math.sqrt(P) - 1) / 2); // Which ring (layer) the cell is in
                int start = (2 * ring - 1) * (2 * ring - 1); // The first position of this ring
                int sideLength = 2 * ring;
                int pos = P - start; // Position within this ring

                if (pos < sideLength) {
                    x = center + ring;
                    y = center + ring - pos;
                } else if (pos < 2 * sideLength) {
                    x = center + ring - (pos - sideLength);
                    y = center - ring;
                } else if (pos < 3 * sideLength) {
                    x = center - ring;
                    y = center - ring + (pos - 2 * sideLength);
                } else {
                    x = center - ring + (pos - 3 * sideLength);
                    y = center + ring;
                }
            }

            System.out.println("Line = " + x + ", column = " + y + ".");
        }

        sc.close();
    }
} // end
