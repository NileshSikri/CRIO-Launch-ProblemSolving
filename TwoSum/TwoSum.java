import java.io.*;
import java.util.*;

public class TwoSum {
    // Implement your solution by completing the below function	
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int c = target - nums[i];
            if(map.containsKey(c))
            {
                return new int[] {map.get(c),i};
            }
            map.put(nums[i],i);
        }
        // throw new IllegalArgumentException("No solution for TWo Sum");
        // throw new IllegalArgumentException("No two sum solution");
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[scanner.nextInt()];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();
        int target = scanner.nextInt();
        scanner.close();

        int[] complements = new TwoSum().twoSum(numbers, target);
        System.out.print(complements[0] + " " + complements[1]);
    }
}
