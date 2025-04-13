package org.interview.questions.others;

public class FibonacciSequence {
    
    public static long fibonacci(int n){
    if(n < 0){
        throw new IllegalArgumentException("n cannot be non-negative");
    }
    if(n==0)
        return 0;
    if(n == 1)
        return 1;
    long a = 0;
    long b = 1;

    for(int i=2; i<= n ;i++){
        long c = a+b;
        a = b;
        b = c;
    }
    return b;
    }

    public static void main(String[] args) {
        int n = 10; // Change this value to compute a different Fibonacci number.
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));

        // Optionally, print the Fibonacci sequence up to the nth number.
        System.out.println("Fibonacci sequence up to " + n + ":");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }
}
