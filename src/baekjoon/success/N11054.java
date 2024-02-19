import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] lengthB = new int[N];
        int[] lengthS = new int[N];
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = -1;
        for (int i = 0; i < N; i++) {
            lengthB[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    lengthB[i] = Math.max(lengthB[i], lengthB[j] + 1);
                }
                else if (A[j] > A[i]) {
                    lengthS[i] = Math.max(lengthS[i], Math.max(lengthB[j] + 1, lengthS[j] + 1));
                }
            }
            max = Math.max(max, Math.max(lengthB[i], lengthS[i]));
        }

        System.out.println(max);
    }
}
