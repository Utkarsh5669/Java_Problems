//First Approach in DP

import java.util.HashMap;

public class FibonacciMemorization {
    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int fibonacci(int n) {
        if (n <= 1) return n;

        if (!memo.containsKey(n)) {
            memo.put(n, fibonacci(n - 1) + fibonacci(n - 2));
        }

        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10)); // Output: 55
    }
}
