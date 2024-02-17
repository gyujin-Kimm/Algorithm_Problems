import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int switches = countSwitches(A, B);
            System.out.println(switches);
        }
    }

    private static int countSwitches(int A, int B) {
        int switches = 0;
        int divisor = 1;
        while (A > 0 || B > 0) {
            int digitA = A % 10;
            int digitB = B % 10;
            switches += countSwitchesForDigit(digitA, digitB);
            A /= 10;
            B /= 10;
            divisor *= 10;
        }
        return switches;
    }

    private static int countSwitchesForDigit(int digitA, int digitB) {
        boolean[][] patterns = {
            {true, true, false, true, true, true, true}, // 0
            {false, true, false, false, true, false, false}, // 1
            {true, true, true, false, false, true, true}, // 2
            {true, true, true, false, true, true, false}, // 3
            {false, true, true, true, true, false, false}, // 4
            {true, false, true, true, true, true, false}, // 5
            {true, false, true, true, true, true, true}, // 6
            {true, true, false, true, true, false, false}, // 7
            {true, true, true, true, true, true, true}, // 8
            {true, true, true, true, true, true, false} // 9
        };
        int switches = 0;
        boolean[] patternA = patterns[digitA];
        boolean[] patternB = patterns[digitB];
        for (int i = 0; i < 7; i++) {
            if (patternA[i] != patternB[i]) {
                switches++;
            }
        }
        return switches;
    }
}
