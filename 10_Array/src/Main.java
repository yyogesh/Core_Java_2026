import java.util.ArrayList;

public class Main {
    public static void main(String[] ar){
        declaration();
        initialization();
        accessing();
        multidimensional();
        increaseingSize();
        programs();
    }

    static void declaration() {
        System.out.println("\n1. ARRAY DECLARATION METHODS:");
        System.out.println("-----------------------------");

        // Declare then create
        int[] arr1;
        arr1 = new int[5];
        System.out.println("Method 1: int[] arr1; arr1 = new int[5];");


        int[] arr2= new int[5];

        int[] arr3 = {1, 2, 3, 4, 5};

        int[] arr5= new int[]{1, 2, 3, 4, 5};

        // Object // heap
       // int arr2[];
    }

    static void initialization() {
        System.out.println("\n\n2. ARRAY INITIALIZATION:");
        System.out.println("------------------------");

        int[] numbers = new int[5];

        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

        String[] fruits = {"Apple", "Banana", "Cherry"};

        for(String fruit : fruits) {
            System.out.print(fruit + " ");
        }
    }

    static void accessing() {
        System.out.println("\n\n3. ACCESSING ARRAY ELEMENTS:");
        System.out.println("----------------------------");

        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("Array: {10, 20, 30, 40, 50}");
        System.out.println("First element (index 0): " + arr[0]);
        System.out.println("Third element (index 2): " + arr[2]);
        System.out.println("Last element (index " + (arr.length-1) + "): " + arr[arr.length-1]);

        int[] arr1 = new int[10];
        System.out.println(arr1.length);
        System.out.println(arr1[0]);
    }

    static void multidimensional() {
        System.out.println("\n\n\n6. MULTIDIMENSIONAL ARRAYS:");
        System.out.println("---------------------------");

        int[][] matrix = {
                {1, 2, 3, 10},
                {4, 5, 6},
                {7, 8, 9, 12}
        };

       // matrix[1][0]

        for(int i =0; i< matrix.length; i++) {
            for(int j = 0;j < matrix[i].length;j++){
                System.out.println(matrix[i][j]);
            }
        }

        int[][] jagged = new int[3][];
        jagged[0] = new int[2];
        jagged[1] = new int[3];
        jagged[2] = new int[1];

        int[][][] cube = new int[2][2][2];

    }

    static void increaseingSize() {
        System.out.println("\n\n7. INCREASING ARRAY SIZE:");
        System.out.println("-------------------------");

        System.out.println("Problem: Arrays have FIXED size in Java");
        System.out.println("Solution: Create new array and copy elements\n");

        int[] original = {1, 2, 3};
        System.out.println("Original array length: " + original.length);
        System.out.print("Elements: ");
        for (int num : original) System.out.print(num + " ");

        System.out.println("\n\nMethod 1 - Manual copying:");
        int[] larger = new int[5];

        for (int i = 0; i < original.length; i++) {
            larger[i] = original[i];
        }

        larger[3] = 4;
        larger[4] = 5;

        System.out.print("New array: ");
        for (int num : larger) System.out.print(num + " ");

        int[] copy1 = new int[5];
        System.arraycopy(original, 0,copy1, 0, original.length);

        System.out.print("Copied array: ");
        for (int num : copy1) System.out.print(num + " ");

        int[] copy2 =java.util.Arrays.copyOf(original, 5);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

    }

    static void programs() {
        int[] arr = {5, 2, 8, 1, 9, 3};

        int sum = 0;
        for(int num: arr) sum += num;
        System.out.println("Sum of elements: " + sum);

        int max = arr[0];
        for(int num: arr){
            if(num> max) max = num;
        }

        int target =  8;
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                index =  i;
                break;
            }
        }
        System.out.println("Element " + target + " found at index: " + index);

        int[] sortArr= arr.clone();
        java.util.Arrays.sort(sortArr);

        System.out.print("Sorted array: ");
        for (int num : sortArr) System.out.print(num + " ");

    }
}
