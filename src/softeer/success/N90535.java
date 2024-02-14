import java.io.*;
import java.util.*;

public class Main {
    static int[] weight;
    static int K;
    static int M;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weight = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        permute(0);

        System.out.println(result);
    }

    public static void permute(int start) {
        if (start == weight.length - 1) {
            result = Math.min(result, bestVal());
            return;
        }

        for (int i = start; i < weight.length; i++) {
            swap(start, i);
            permute(start + 1);
            swap(start, i); 
        }
    }

    public static void swap(int i, int j) {
        int temp = weight[i];
        weight[i] = weight[j];
        weight[j] = temp;
    }

    private static int bestVal() {
        int left = 0;
        int right = 0;
        int cnt = 0;
        int ans = 0;
        while (cnt < K) {
            int sum = 0;
            int lastVal = 0;
            for (int i = left; i <= right; i++) {
                sum += weight[i % weight.length];
                lastVal = weight[i % weight.length];
            }
            if (sum <= M) {
                right++;
                continue;
            }
            ans += sum - lastVal;
            left = right;
            cnt++;
        }
        return ans;
    }
}
