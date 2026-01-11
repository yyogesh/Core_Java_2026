import java.util.Arrays;

public class Main {
    public static void main(String[] arg) {
        problem1_TwoSum();
        removeDuplicates();
        maximumSubarray();
        bestTimeBuySellStock();
        secondLargest();
    }

    static void problem1_TwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        for(int i = 0; i < nums.length; i++) {
            for(int j =i + 1; j < nums.length; j++) {
             if(nums[i] + nums[j] == target) {
                 System.out.println("Output : [" + i + ", " + j + "]");
             }
            }
        }
    }

    static void removeDuplicates() {
        int[] nums = {1, 1, 2, 2, 3, 4, 4};
        System.out.println("Input: " + Arrays.toString(nums));

        int j = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[j]) { // 1
                j++;
                nums[j] = nums[i];
            }
        }
        System.out.print("Output: k = " + (j + 1) + ", nums = [");
        for (int i = 0; i <= j; i++) {
            System.out.print(nums[i] + (i < j ? ", " : ""));
        }
        System.out.println("]");

        System.out.println("Output: " + Arrays.toString(nums));
    }

    static void maximumSubarray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // -11 , 12

        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum +  nums[i]);
            System.out.println(currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println("Output: " + maxSum);
    }

    static void bestTimeBuySellStock() {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price: prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
            System.out.println(price + " :: " + minPrice + " :: " + maxProfit);
        }

        System.out.println(maxProfit);

    }

    static void secondLargest(){
        int[] arr = {12, 35, 1, 10, 34, 1, 35};

        int largest = Integer.MIN_VALUE;// 0
        int secondLargest = Integer.MIN_VALUE; // 0

        for(int num: arr) { // 12, 35, 1, 34
            if(num > largest){ // 35 > 12
                secondLargest = largest; // 12
                largest = num; // 35
            } else if (num > secondLargest && num != largest) { // true
                secondLargest = num;
            }
        }// O(n)

        System.out.println("second largest: " + secondLargest);
    }

}
