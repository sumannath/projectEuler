package in.nuphos.projectEuler;

import java.util.Scanner;

public class Problem18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 1 ; i <= T ; i++) {
            int N = scan.nextInt();
            int[][] arr = new int[N][N];
            int max = Integer.MIN_VALUE;
            for(int x = 0 ; x < N ; x++) {
                for(int y = 0 ; y <= x ; y++) {
                    arr[x][y] = scan.nextInt();
                    if(x > 0) {
                        if(y > 0) {
                            arr[x][y] = Math.max(arr[x][y] + arr[x - 1][y], arr[x][y] + arr[x - 1][y - 1]);
                        } else {
                            arr[x][y] = arr[x][y] + arr[x - 1][y];
                        }
                        max = Math.max(max, arr[x][y]);
                    } else {
                        max = arr[x][y];
                    }
                }
            }
            System.out.println(max);
        }
        scan.close();
    }
}
