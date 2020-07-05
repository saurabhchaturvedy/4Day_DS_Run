package Recursion;

public class Factorial {


    private static int factorialIterative(int num) {
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    private static int factorialRecursive(int num) {
        if (num == 0) return 1;
        return num * factorialRecursive(num - 1);
    }

    public static void main(String[] args) {
        int x = 4;
        System.out.println("factorial (Iterative) of " + x + " is " + factorialIterative(x));
        System.out.println("factorial (Recursive) of " + x + " is " + factorialRecursive(x));
    }
}
