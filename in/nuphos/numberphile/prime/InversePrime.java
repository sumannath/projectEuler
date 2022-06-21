package in.nuphos.numberphile.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InversePrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the value: ");
        int n = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= n ; i++) {
            System.out.println(i + ": " + repeatAfter(i));
        }
    }

    public static int repeatAfter(int n) {
        StringBuilder sbQuotient = new StringBuilder();
        int ctr = 0;
        if(n == 1) {
            sbQuotient.append(1);
        } else if(n < 1) {
            sbQuotient.append(-1);
        } else {
            int x = 1;
            sbQuotient.append("0.");
            x *= 10;
            while(x < n) {
                sbQuotient.append(0);
                x *= 10;
            }
            int q;
            ArrayList<Integer> mulList = new ArrayList<>();
            do {
                q = x / n;
                x -= q*n;
                if(mulList.contains(x)) {
                    break;
                }
                mulList.add(x);
                x *= 10;
                sbQuotient.append(q);
                ctr++;
            } while(true);
        }

        return ctr;
    }
}
