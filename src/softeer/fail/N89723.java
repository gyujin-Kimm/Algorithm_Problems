import java.io.*;
import java.util.*;

// https://softeer.ai/app/assessment/index.html?xid=89723&xsrfToken=K7FJywV4F3zfODGq04TlelTIMgXTrP78&testType=practice

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static int R, C = 0;
    static boolean isHome;
    static int[][] shortMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        
        int homeX = 0;
        int homeY = 0;
        int washX = 0;
        int washY = 0;
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'W') {
                    washX = i;
                    washY = j;
                    continue;
                }
                else if (map[i][j] == 'H') {
                    homeX = i;
                    homeY = j;
                    continue;
                }
                
            }
        }

        shortMap = new int[R][C];

        bfs(washX, washY);

        int cnt = shortMap[homeX][homeY];
        String answer = (cnt == 0) ? "FAIL" : Integer.toString(cnt); 
        
        System.out.println(answer);
        
    }
    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        boolean[][] isVisited = new boolean[R][C];
        isVisited[row][col] = true;
        
        while(!queue.isEmpty()) {
            rainMove();
            int[] newNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + newNode[0];
                int y = dy[i] + newNode[1];
                if (0 <= x && 0 <= y && x < R && y < C && !isVisited[x][y]) {
                    if (map[x][y] != '*' && map[x][y] != 'X') {
                        
                        // map[newNode[0]][newNode[1]] = ".";
                        // map[x][y] = "W";
                        shortMap[x][y] = shortMap[newNode[0]][newNode[1]] + 1;
                        queue.add(new int[] {x, y});
                        isVisited[x][y] = true;
                        if (map[x][y] == 'H') {
                            isHome = true;
                            break;
                        }
                    }
                }        
            }
        }
    }
    private static void rainMove() {
        boolean[][] isRainism = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*' && !isRainism[i][j]) {
                    isRainism[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int x = dx[k] + i;
                        int y = dy[k] + j;
                        if (0 <= x && 0 <= y && x < R && y < C) {
                            if (map[x][y] == '.' && !isRainism[x][y]) {
                                isRainism[x][y] = true;
                                map[x][y] = '*';
                            }
                        }
                    }
                }
            }
        }
    }
}