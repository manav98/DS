//Largest Sum Contiguous Subarray
class Kadane
{
    private static int maxSubArraySum(int[] arr)
    {
        int max = 0;
        int finalMax = 0;
        for (int i = 0; i < arr.length; i++)
        {
            max = max + arr[i];
            if (max < 0)
            {
                max = 0;
            }
            if (finalMax < max)
            {
                finalMax = max;
            }
        }
        return finalMax;
    }

    public static void main(String[] args)
    {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }
}
