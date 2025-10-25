
 // Homework09

public class Homework09 {

    public static void main(String[] args) {
        // I call my method to find the first triangle number with over 100 divisors
        long answer = firstTriangleWithDivisorsOver(100);

        // I print the result
        System.out.println("The first triangle number with over 100 divisors is: " + answer);
    }

    /**
     * I use this method to find the first triangle number with more than 'limit' divisors.
     */
    public static long firstTriangleWithDivisorsOver(int limit) {
        long n = 1; // I start from the first natural number

        while (true) {
            long a, b;

            // If n is even, I divide n by 2 and multiply by (n+1)
            // If n is odd, I divide (n+1) by 2 and multiply by n
            if (n % 2 == 0) {
                a = n / 2;
                b = n + 1;
            } else {
                a = n;
                b = (n + 1) / 2;
            }

            // I calculate total divisors by multiplying divisors of both parts
            int totalDivisors = countDivisors(a) * countDivisors(b);

            // If I find a triangle number with more than the limit divisors, I return it
            if (totalDivisors > limit) {
                return n * (n + 1) / 2;
            }

            // Otherwise, I move to the next natural number
            n++;
        }
    }

    /**
     * I use this helper method to count how many divisors a number has.
     * I use prime factorization to make it efficient.
     */
    public static int countDivisors(long num) {
        if (num == 1) return 1;

        int total = 1;
        int exponent = 0;

        // I count the power of 2 factors first
        while (num % 2 == 0) {
            num /= 2;
            exponent++;
        }
        if (exponent > 0) total *= (exponent + 1);

        // I count other prime factors (odd numbers)
        for (long i = 3; i * i <= num; i += 2) {
            exponent = 0;
            while (num % i == 0) {
                num /= i;
                exponent++;
            }
            if (exponent > 0) total *= (exponent + 1);
        }

        // If there’s a prime left at the end, it contributes two divisors
        if (num > 1) total *= 2;

        return total;
    }
}
