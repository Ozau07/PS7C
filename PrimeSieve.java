import java.util.ArrayList;

public class PrimeSieve {

    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n +1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]){
       
                for (int multiple = p*2;multiple <=n; multiple +=p) {
                    isPrime[multiple]= false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
