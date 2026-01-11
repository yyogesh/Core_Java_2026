public class FactorialRecursion {
    static int factorial(int n) {
        // 5 5*4*3*2*1 ===>
        if(n== 0 || n == 1) {
            return 0;
        }
        return n * factorial(n-1);
        // 5 * 5-1
        // 4 * 4-1

        // 120 * 1

    }
}
