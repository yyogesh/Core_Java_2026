public class Main {
    public  static void main(String arg[]){
        String str1 = "Hello Java";

        String str2= new String("Java");

        char c[]= {'A', 'B'};

        String str3 = new String(c);

        byte b[] = {65, 66};

        String str4 = new String(b);

        String str5 = "Hello Java";

        String st6 = new String("Hello Java");

        String str7 = "Hello java";

        System.out.println(str1 == st6);


        String str = "   Java Programming Language  ";
        System.out.println("Length: " + str.length());

        String trimmed = str.trim();
        System.out.println("Trimmed: '" + trimmed + "'");

        System.out.println("Lowercase: " + trimmed.toLowerCase());

        System.out.println("Uppercase: " + trimmed.toUpperCase());

        System.out.println("Substring from index 5: " + trimmed.substring(5));

        System.out.println("Substring (5,16): " + trimmed.substring(5, 16));

        System.out.println("Replace a with x: " + trimmed.replace('a', 'x'));

        System.out.println("Starts with Java: " + trimmed.startsWith("Java"));
        System.out.println("Ends with Language: " + trimmed.endsWith("Language"));

        System.out.println("Character at index 2: " + trimmed.charAt(2));

        System.out.println("Index of 'a': " + trimmed.indexOf('a'));
        System.out.println("Last index of 'a': " + trimmed.lastIndexOf('a'));

        String s2 = "java programming language";
        System.out.println("Equals: " + trimmed.equals(s2));
        System.out.println("Equals Ignore Case: " + trimmed.equalsIgnoreCase(s2));

        System.out.println("CompareTo 'Java': " + trimmed.compareTo("Java"));

        int num = 500;
        String numStr = String.valueOf(num);
        System.out.println("ValueOf int: " + numStr);

        System.out.println("Contains Programming: " + trimmed.contains("Programming"));

        String[] words = trimmed.split(" ");

        //System.gc(); // request

        // . [abc][^] [1-7]A|B
    }
}
