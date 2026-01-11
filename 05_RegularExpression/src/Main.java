import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String arg[]) {
        //match, search, validate, split, replace

        // java.util.regex.Pattern

        // [a-z]
        // [a-z0-9]
        // [^a-z]
        // /d /D /w /W /s /S
        //  \d   digit [0-9]
        //  \D   non-digit
        //  \w   word character
        //  \W   non-word character
        //  \s   whitespace
        //  \S   non-whitespace

        // * // *abc*

//        *    0 or more
//        +    1 or more
//         ?    0 or 1
//        {n}  exactly n times
//        {n,} at least n times
//        {n,m} between n and m times

        // $ end of string
        // ^ start of string
        // \b word boundary

        // ()
        // |
        // . any char

        String email = "test%123@gmail.com";

        System.out.println(email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._]+\\.com"));

        String input = "Order123 costs 4500 and discount 500";

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        System.out.println("Numbers found:");

        while (matcher.find()) {
            System.out.println(matcher.group() + " at index " + matcher.start());
        }

        String mobile="8876543210";

        System.out.println(mobile.matches("[6-9][0-9]{9}"));

        String text = "Java@123#Programming!";
        System.out.println(text.replaceAll("[^a-zA-Z ]", ""));
    }
}
