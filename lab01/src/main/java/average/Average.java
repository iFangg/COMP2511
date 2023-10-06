package average;

public class Average {
    /**
     * Returns the average of an array of numbers
     *
     * @param nums the array of integer numbers
     * @return the average of the numbers
     */
    public float computeAverage(int[] nums) {
        float result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return result / nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Average getAvg = new Average();
        float avg = getAvg.computeAverage(nums);
        System.out.println("The average is " + avg);
    }
}
