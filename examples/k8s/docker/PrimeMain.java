public class PrimeMain {
    public static int cnt = 0;

    private static boolean isPrime(int num) {
        if (num == 2)
            return true;
        if (num < 2 || num % 2 == 0)
            return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        for (int i = 2; i < Math.pow(10, 9); ++i) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        System.out.println("Total number of primes: " + cnt);
    }

}
