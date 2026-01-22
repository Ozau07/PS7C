public class BigIntAdder {

    public static int[] add(int[] a, int[] b) {
        int maxLength = a.length;
        if (b.length > maxLength) {
            maxLength = b.length;
        }

        int[] result = new int[maxLength + 1];
        int carry = 0;
        int i = a.length - 1;
        int j = b.length - 1;
        int k = result.length - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digitA = 0;
            if (i >= 0) {
                digitA = a[i];
            }

            int digitB = 0;
            if (j >= 0) {
                digitB = b[j];
            }
            int sum = digitA + digitB + carry;
            result[k] = sum % 10;
            carry = sum / 10;
            i--;
            j--;
            k--;
        }
        if (result[0] == 0) {
            int[] trimmed = new int[result.length - 1];
            for (int m = 1; m < result.length; m++) {
                trimmed[m - 1] = result[m];
            }
            return trimmed;
        }

        return result;
    }

}
