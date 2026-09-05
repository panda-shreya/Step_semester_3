import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        answer[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        System.out.println(
            Arrays.toString(productExceptSelf(nums))
        );
    }
}