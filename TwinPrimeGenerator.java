/* 
   Provides a public static method generateTwinPrime(int min, int max) 
   that generates a value for the HashTable table size m in the range of [min:max].
   A good table size is a twin prime m that is 2 away from another prime (such that m and m − 2 are primes).  
   Two primes that differ by two are called “twin primes.”  
   The method to generate twin primes should find the smallest set of twin primes both in the given range and then return the larger of the two. 
   The HashtableExperiment class will call generateTwinPrime(95500, 96000) to get an appropriate twin prime for the experiment. 
   This allows us to all use the same table size and be able to compare some of the results.
*/

public class TwinPrimeGenerator {

    
    public static int generateTwinPrime(int min, int max) {
        // Loop through all intergers from min to max and search for pairs of prime numbers
        // Note: This is probably an inefficient approach. 
        for (int i = min; i <= max; i++) {
            if (isPrime(i) && isPrime(i - 2)) {
                return i;
            }
        }
        throw new IllegalArgumentException("No twin prime found in the given range");
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
