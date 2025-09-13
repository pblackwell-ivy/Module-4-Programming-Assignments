package Exercise24_4;

/**
 * 24.4 (Use the GenericStack class) Write a program that displays the first 50 prime numbers in descending order.
 * Use a stack to store the prime numbers.
 * 1. Create primeStack to hold the prime numbers using the GenericStack class
 * 2. Starting at 2, find the first 50 prime numbers and add them to the stack
 *      - uses helper method isPrime(int n) to test if a number is prime
 * 3. Pop off stack elements and display them until the stack is empty.
 */
public class Exercise24_4 {
    public static void main(String[] args) {
        // Create a primeStack using the GenericStack
        GenericStack<Integer> primeStack = new GenericStack<Integer>();

        int count = 0;   // how many primes we’ve found
        int number = 2;  // start checking from 2

        // Find first 50 prime numbers
        while (count < 50) {
            if (isPrime(number)) {
                primeStack.push(number);  // add to stack
                count++;
            }
            number++;
        }

        // Display in descending order (stack pops last-in first-out)
        System.out.println("The first 50 prime numbers in descending order:");
        while (!primeStack.isEmpty()) {
            System.out.print(primeStack.pop() + " ");
        }
    }

    /** Helper method to check if a number is prime.
     * A prime number is a number that is greater than 1 and has only two factors, 1 and itself.
     * Therefore, 2 is the first prime number.
     * Loop checking n % divisor by an increasing divisor until halfway to the number
     * @param n: the int number to check
     * @return true if a prime, false, if not a prime
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int divisor = 2; divisor <= n / 2; divisor++) {
            if (n % divisor == 0) return false;
        }
        return true;
    }
}