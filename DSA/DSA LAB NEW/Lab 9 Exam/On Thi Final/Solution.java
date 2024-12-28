import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] firstLine = br.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            int K = Integer.parseInt(firstLine[1]);

            int[] A = new int[N];
            String[] strengths = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(strengths[i]);
            }

            int[] D = new int[K];
            String[] hurdles = br.readLine().split(" ");
            for (int i = 0; i < K; i++) {
                D[i] = Integer.parseInt(hurdles[i]);
            }

            int maxH = 0;
            for (int i = 0; i < K; i++) {
                maxH = Math.max(maxH, D[i]);
            }

            int maxHurdles = -1;
            int winnerID = -1;

            for (int i = 0; i < N; i++) {
                if (A[i] >= maxH) {
                    if (maxHurdles < K || (maxHurdles == K && i < winnerID)) {
                        maxHurdles = K;
                        winnerID = i;
                    }
                } else {
                    int hurdlesCrossed = 0;
                    for (int j = 0; j < K; j++) {
                        if (A[i] >= D[j]) {
                            hurdlesCrossed++;
                        } else {
                            break;
                        }
                    }
                    if (hurdlesCrossed > maxHurdles || (hurdlesCrossed == maxHurdles && i < winnerID)) {
                        maxHurdles = hurdlesCrossed;
                        winnerID = i;
                    }
                }
            }

            sb.append(winnerID).append("\n");
        }

        System.out.print(sb.toString());
    }
}