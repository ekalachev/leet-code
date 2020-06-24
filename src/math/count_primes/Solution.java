package math.count_primes;

public class Solution {
    public int countPrimes(int n) {
        if(n <= 1) return 0;
        
        boolean[] composites = new boolean[n + 1];
        
        for(int i = 4; i <= n; i += 2) {
            composites[i] = true;
        }
        
        int nextPrime = 3;
        double stopAt = Math.sqrt(n);
        while(nextPrime <= stopAt) {
            for(int i = nextPrime * 2; i < n; i += nextPrime) {
                composites[i] = true;
            }
            nextPrime += 2;
            while(nextPrime <= n && composites[nextPrime]) {
                nextPrime += 2;
            }
        }
        
        int countOfPrimeNumbers = 0;
        for(int i = 0; i < n; i++) {
            if(!composites[i]) countOfPrimeNumbers++;
        }
        
        return countOfPrimeNumbers - 2;
    }

    public static void main(final String[] args) {
        int n = 10;
        Solution solution = new Solution();
        int result = solution.countPrimes(n);

        System.out.println("Count fof primes for " + n + " = " + result);
    }
}