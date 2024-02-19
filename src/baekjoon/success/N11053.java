import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] length = new int[N];
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = -1;
        for (int i = 0; i < N; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
            max = Math.max(max, length[i]);
        }

        System.out.println(max);
    }
}
