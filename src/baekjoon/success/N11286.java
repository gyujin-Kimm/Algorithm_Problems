import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) > Math.abs(o2)) {
                return Math.abs(o1) - Math.abs(o2);
            }
            else if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }
            else {
                return -1;
            }
        });

/*        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
              if (Math.abs(o1) > Math.abs(o2)) {
                  return Math.abs(o1) - Math.abs(o2);
              }
             else if (Math.abs(o1) == Math.abs(o2)) {
                  return o1 - o2;
              }
              else {
                  return -1;
              }
            }
        });

 */

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (queue.isEmpty()) {
                    sb.append('0').append('\n');
                    continue;
                }
                sb.append(queue.poll()).append('\n');
                continue;
            }
            queue.add(num);
        }

        System.out.println(sb);
    }
}