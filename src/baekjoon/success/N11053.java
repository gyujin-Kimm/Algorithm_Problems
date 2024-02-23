import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] length = new int[N];
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = -1;
        for (int i = 0; i < N; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
            max = Math.max(max, length[i]);
        }

        System.out.println(max);
    }
}

// 이진 탐색

// import java.io.*;
// import java.util.*;

// public class Main {
//     static int N;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         N = Integer.parseInt(br.readLine());
//         int[] lis = new int[N];
//         int[] A = Arrays.stream(br.readLine().split(" "))
//                 .mapToInt(Integer::parseInt)
//                 .toArray();
//         lis[0] = A[0];

//         int len = 1;
//         for (int i = 1; i < N; i++) {
//             if (lis[len - 1] < A[i]) {
//                 lis[len++] = A[i];
//             }
//             else if (lis[len - 1] > A[i]) {
//                 int idx = binarySearch(lis, 0, len - 1, A[i]);
//                 lis[idx] = A[i];
//             }
//         }

//         System.out.println(len);
//     }
//     private static int binarySearch(int[] lis, int left, int right, int target) {
//         int mid;
//         while (left < right) {
//             mid = ((right + left) % N) / 2;
//             if (lis[mid] < target) {
//                 left = mid + 1;
//             } else {
//                 right = mid;
//             }
//         }
//         return right;
//     }
// }
