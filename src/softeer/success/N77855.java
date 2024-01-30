import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int[] arr = new int[N + 1];
        boolean[] winner = new boolean[N + 1];
        Arrays.fill(winner, true);
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (arr[num1] < arr[num2]) {
                winner[num1] = false;
                continue;
            }
            else if (arr[num1] == arr[num2]) {
                winner[num1] = false;
                winner[num2] = false;
                continue;
            }
            winner[num2] = false;
        }
        
        for (int i = 1; i <= N; i++) {
            if (winner[i]) cnt++;
        }
        
        System.out.println(cnt);
    }
}
