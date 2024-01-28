import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int bagWeight = W;

        PriorityQueue<Jewelry> queue = new PriorityQueue<Jewelry>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            queue.offer(new Jewelry(M, P));
        }

        int result = 0;

        while(!queue.isEmpty()) {
            Jewelry jewelry = queue.poll();
            if (bagWeight < jewelry.weight) {
                result += bagWeight * jewelry.perPrice;
                break;
            } 
            result += jewelry.weight * jewelry.perPrice;
            bagWeight -= jewelry.weight;
        }
            System.out.println(result);

    }
    public static class Jewelry implements Comparable<Jewelry> {
        public int weight;
        public int perPrice;

        public Jewelry(int weight, int perPrice) {
            this.weight = weight;
            this.perPrice = perPrice;
        }

        @Override
        public int compareTo(Jewelry jewelry) {
            return (this.perPrice < jewelry.perPrice) ? 1 : -1;
        }
    }
}
