import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] rooms = new String[N];
        boolean[][] time = new boolean[N][10];

        for (int i = 0; i < N; i++) {
            rooms[i] = br.readLine();
            time[i][9] = true;
        }

        Arrays.sort(rooms);

        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Arrays.asList(rooms).indexOf(st.nextToken());
            int start = Integer.parseInt(st.nextToken()); 
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end; j++) {
                time[idx][j-9] = true;
            }   
        }

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            System.out.printf("Room %s:\n", rooms[i]);
            int cnt = 0;
            boolean flag = true;
            for (int j = 0; j < 10; j++) {
                if (!time[i][j] && flag) {
                    if (j == 0) sb.append("0");
                    sb.append(j + 9);
                    flag = false;
                    cnt++;
                }
                else if(time[i][j] && !flag) {
                    sb.append("-").append(j+9).append('\n');
                    flag = true;
                }
                
            }
            if (cnt == 0) {
                System.out.println("Not available");
            } 
            else if (cnt > 0) {
                System.out.println(cnt + " available:");
                System.out.print(sb);
            }
            
            if (i+1 < N) {
                System.out.println("-----");
            }
        }
        
    }
}
