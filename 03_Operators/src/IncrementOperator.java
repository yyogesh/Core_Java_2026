public class IncrementOperator {
    public static void Increment() {
        int x = 5, y;
        y = x++;
        System.out.println(y + " " + x);

        int x1 = 5, y1;
        y1 = ++x1;
        System.out.println(y1 + " " + x1);

        float x2 = 6.2f;
        System.out.println(++x2);

        char x3= 'A'; // 65
        x3++;
        System.out.println(x3); // 66

        int a = 2, b = 5, c;

        c = 3*a++ + 4 * ++a;

        System.out.println(c);
    }
}

// & | ~ ^  >> <<
// 01
