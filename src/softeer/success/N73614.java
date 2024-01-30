import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = 0;

        int[][] limit = new int[N][N];
        int[][] test = new int[M][M];

        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            limit[i][0] = Integer.parseInt(st.nextToken());
            limit[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            test[i][0] = Integer.parseInt(st.nextToken());
            test[i][1] = Integer.parseInt(st.nextToken());
        }
        int i = 0;
        int j = 0;
        while (i < limit.length && j < test.length) {
            if (limit[i][0] == test[j][0]) {
                max = Math.max(max, test[j][1] - limit[i][1]);
                i++;
                j++;
                continue;
            }
            
            if (limit[i][0] < test[j][0]) {
                max = Math.max(max, test[j][1] - limit[i][1]);
                test[j][0] = test[j][0] - limit[i][0];
                i++;
                continue;
            }
            max = Math.max(max, test[j][1] - limit[i][1]);
            limit[i][0] = limit[i][0] - test[j][0];
            j++;
        }

        System.out.println(max);
    }
}
