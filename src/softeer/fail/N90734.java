import java.io.*;
import java.util.*;

// https://softeer.ai/app/assessment/index.html?xid=90734&xsrfToken=GtdQh7gf0HF5lRoRjpn2khHeuUxdSQYg&testType=practice

public class Main {
    static int N, M = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[] nucleic = {'a', 'c', 'g', 't'};
        char[][] sequence = new char[N][M];

        for (int i = 0; i < N; i++) {
            String DNA = br.readLine();
            for (int j = 0; j < M; j++) {
                sequence[i][j] = DNA.charAt(j);
            }
        }

        char compareCh = '';
        boolean[] passNucleic = new boolean[N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N - 1; j++) {
                char compareCh = sequence[j][i];
                for (int k = j + 1; k < N; k++) {
                    char ch = sequence[k][i];
                    if (compareCh == '.' || compareCh == ch) {
                        
                    }
                }
            }
        }
    }
    
}
