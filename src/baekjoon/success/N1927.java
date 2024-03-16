import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                queue.add(num);
                continue;
            }
            if (queue.isEmpty()) {
                sb.append('0').append('\n');
                continue;
            }
            sb.append(queue.poll()).append('\n');
        }

        System.out.println(sb);
    }
}