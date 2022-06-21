package in.nuphos.projectEuler;

import java.util.HashMap;
import java.util.Scanner;

/*
 * The following iterative sequence is defined for the set of positive integers:
 *     n → n/2 (n is even)
 *     n → 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 *     13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been
 * proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * https://projecteuler.net/problem=14
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler014/problem?isFullScreen=true
 */
public class Problem14Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[] collatzSteps = new int[5000001];
        collatzSteps[1] = 0;
        int max, steps;
        long maxN = 0;
        for(int i = 1 ; i <= T ; i++) {
            int N = scan.nextInt();
            max = 0;
            for(int x = 1 ; x <= N ; x++) {
                steps = getCollatzSteps(x, collatzSteps);
                collatzSteps[x] = steps;
                if(steps >= max) {
                    max = steps;
                    maxN = x;
                }
            }
            System.out.println(maxN);
        }
        scan.close();
    }

    private static int getCollatzSteps(int x, int[] collatzSteps) {
        int steps = 0;
        int nSteps = collatzSteps[x];
        if(nSteps != 0) {
            return nSteps;
        } else {
            if(x % 2 == 0) {
                return 1 + getCollatzSteps(x >> 1, collatzSteps);
            } else {
                return 1 + getCollatzSteps(3*x + 1, collatzSteps);
            }
        }
    }
}
