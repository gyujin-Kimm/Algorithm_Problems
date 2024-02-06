import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int row = 2;
        
        while(cnt <= N) {
            row = (2 * row) - 1;
            cnt++;
        }
        System.out.println(row * row);
    }
}
