

class CountCoPrimes {
    // Optimized function to count coprime pairs
    public static int countCoprimes(int[] arr) {
        int max = 0;
        for (int x : arr) max = Math.max(max, x);
        int[] freq = new int[max + 1];
        for (int x : arr) freq[x]++;

        // Count multiples for each number
        int[] multiples = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                multiples[i] += freq[j];
            }
        }

        // Inclusion-Exclusion Principle
        long[] pairCount = new long[max + 1];
        for (int i = max; i >= 1; i--) {
            pairCount[i] = (long)multiples[i] * (multiples[i] - 1) / 2;
            for (int j = 2 * i; j <= max; j += i) {
                pairCount[i] -= pairCount[j];
            }
        }
        return (int)pairCount[1];
    }

    public static void main(String[] args) {
        int[] arr = {4,8,3,9};
        System.out.println("Count of coprime pairs: " + countCoprimes(arr));
    }
}