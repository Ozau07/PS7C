public class GoldbachConjecture {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n);i++) {
            if (n % i == 0) return false;
        }
        return true;
    }  
    public static void goldbach(int even) {
        for (int i = 2; i <= even / 2;i++) {
            if (isPrime(i)&&isPrime(even -i)) {
                System.out.println(even+" = "+ i + " + " +(even - i));
                return; 
            }
        }
    }
    public static void main(String[] args) {
        goldbach(4);
        goldbach(6);
        goldbach(10);
        goldbach(120);
    }
}
