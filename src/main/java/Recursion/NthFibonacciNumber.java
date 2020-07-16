package Recursion;

public class NthFibonacciNumber {


    private static int NthFibonacciNumber(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return NthFibonacciNumber(n - 1) + NthFibonacciNumber(n - 2);
    }

    public static void main(String[] args) {

        int x = 5;
        System.out.println(x + "th Fibonacci number is " + NthFibonacciNumber(5));
    }
}
