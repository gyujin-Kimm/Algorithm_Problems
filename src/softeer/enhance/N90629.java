import java.io.*;
import java.util.*;

public class Main {
    static int[][] seats;
    static int[] IDs;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        seats = new int[N + 2][M + 2];
        IDs = new int[10001]; // 0: notIn, 1: Out, [x,y]

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String inOut = st.nextToken();
            int pid = Integer.parseInt(st.nextToken());
            CheckingId(inOut, pid);
        }
    }

    private static void CheckingId(String inOut, int pid) {
        if (inOut.equals("In")) {
            if (IDs[pid] == 0) {
                int[] seat = assign();
                if (seat != null) {
                    seats[seat[0]][seat[1]] = pid;
                    IDs[pid] = seat[0] * (M + 2) + seat[1];
                    System.out.println(pid + " gets the seat (" + seat[0] + ", " + seat[1] + ").");
                    return;
                }
                System.out.println("There are no more seats.");
            } else if (IDs[pid] == 1) {
                System.out.println(pid + " already ate lunch.");
            } else {
                System.out.println(pid + " already seated.");
            }
        } else if (inOut.equals("Out")) {
            if (IDs[pid] == 0) {
                System.out.println(pid + " didn't eat lunch.");
            } else if (IDs[pid] == 1) {
                System.out.println(pid + " already left seat.");
            } else {
                int[] seat = {IDs[pid] / (M + 2), IDs[pid] % (M + 2)};
                seats[seat[0]][seat[1]] = 0;
                IDs[pid] = 1;
                System.out.println(pid + " leaves from the seat (" + seat[0] + ", " + seat[1] + ").");
            }
        }
    }

    private static int[] assign() {
        int maxD = 0;
        int[] seat = null;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (seats[i][j] == 0 && seats[i - 1][j] == 0 && seats[i + 1][j] == 0 && seats[i][j - 1] == 0 && seats[i][j + 1] == 0) {
                    int d = nearest(i, j);
                    if (d > maxD) {
                        maxD = d;
                        seat = new int[]{i, j};
                    }
                }
            }
        }
        return seat;
    }

    private static int nearest(int x, int y) {
        int minD = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (seats[i][j] != 0) {
                    int d = (x - i) * (x - i) + (y - j) * (y - j);
                    if (d < minD) {
                        minD = d;
                    }
                }
            }
        }
        return minD;
    }
}
