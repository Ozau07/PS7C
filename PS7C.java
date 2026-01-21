import java.util.ArrayList;

public class PS7C {

    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Integer> numbers = new ArrayList<>();

    
        for (int i = 2; i <= n; i++) {
            numbers.add(i);
        }

        int pIndex = 0;

   
        while (pIndex < numbers.size()) {
            int p = numbers.get(pIndex);

            if (p * p > n) {
                break;
            }

        
            for (int i = numbers.size() - 1; i > pIndex; i--) {
                if (numbers.get(i) % p == 0) {
                    numbers.remove(i);
                }
            }

            pIndex++;
        }

        return numbers;
    }

    public static void goldbach(int evenNum) {
        ArrayList<Integer> primes = sieve(evenNum);

    
        int left = 0;
        int right = primes.size() - 1;

        while (left <= right) {
            int sum = primes.get(left) + primes.get(right);

            if (sum == evenNum) {
                System.out.println(evenNum + " = " +
                        primes.get(left) + " + " + primes.get(right));
                return;
            } else if (sum < evenNum) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    public static ArrayList<Integer> add(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();

        int i = a.size() - 1;
        int j = b.size() - 1;
        int carry = 0;

 
        while (i >= 0 || j >= 0 || carry > 0) {
            int digitA = (i >= 0) ? a.get(i) : 0;
            int digitB = (j >= 0) ? b.get(j) : 0;

            int sum = digitA + digitB + carry;
            carry = sum / 10;

            result.add(0, sum % 10);

            i--;
            j--;
        }

        return result;
    }


    public static void main(String[] args) {


        System.out.println("Primes under 50:");
        System.out.println(sieve(50));

    
        goldbach(4);
        goldbach(6);
        goldbach(10);
        goldbach(120);

  
        ArrayList<Integer> num1 = new ArrayList<>();
        num1.add(9);
        num1.add(8);
        num1.add(0);
        num1.add(1); 

        ArrayList<Integer> num2 = new ArrayList<>();
        num2.add(2);
        num2.add(3);
        num2.add(9);   

        System.out.println("9801 + 239 = " + add(num1, num2));
    }
}
