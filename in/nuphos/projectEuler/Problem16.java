package in.nuphos.projectEuler;

import java.util.Scanner;

public class Problem16 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        String[] powersOf2 = new String[10001];
        powersOf2[0] = "1";
        for(int i = 1 ; i <= T ; i++) {
            int N = scan.nextInt();
            int j = N;
            while(powersOf2[j] == null) {
                j--;
            }
            while(j < N) {
                String nextPowerOf2 = multiplyBy2(powersOf2[j]);
                powersOf2[++j] = nextPowerOf2;
            }
            System.out.println(sumOfDigits(powersOf2[N]));
        }
        scan.close();
    }

    private static int sumOfDigits(String power) {
        int sum = 0, length = power.length();
        for(int i = length - 1 ; i >= 0 ; i--) {
            sum += power.charAt(i) - '0';
        }
        return sum;
    }

    public static String multiplyBy2(String num) {
        int length = num.length();
        StringBuilder sb = new StringBuilder();
        int digit, product, carry = 0;
        for(int i = length - 1 ; i >= 0 ; i--) {
            digit = num.charAt(i) - '0';
            product = (digit*2) + carry;
            if(product > 9) {
                carry = product / 10;
                product %= 10;
            } else {
                carry = 0;
            }
            sb.append(product);
        }
        if(carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
