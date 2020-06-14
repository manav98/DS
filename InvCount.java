//COUNTING THE INVERSIONS

import java.util.Arrays;

public class InvCount
{
    static int mergeCount(int[] arr, int left, int mid, int right)
    {
        int[] L = new int[mid + 1 - left];
        int[] R = new int[right - mid];
        int itr = 0;
        for (int i = left; i <= mid; i++)  //COPYING ARRAY
        {
            L[itr++] = arr[i];
        }
        itr = 0;
        for (int i = mid + 1; i <= right; i++)   //COPYING ARRAY
        {
            R[itr++] = arr[i];
        }
        int inversionCount = 0;
        int i = 0, j = 0;
        int k = left;
        while (i < L.length && j < R.length)
        {
            if (L[i] <= R[j])
            {
                arr[k++] = L[i++];
            }
            else
            {
                arr[k++] = R[j++];
                inversionCount += L.length - i;
            }
        }
        while (i < L.length)
        {
            arr[k++] = L[i++];
        }
        while (j < R.length)
        {
            arr[k++] = R[j++];
        }
        return inversionCount;
    }

    static int countInversions(int[] arr, int left, int right)
    {
        int count = 0;
        if (left < right)
        {
            int mid = (left + right) / 2;
            count += countInversions(arr, left, mid);
            count += countInversions(arr, mid + 1, right);
            count += mergeCount(arr, left, mid, right);
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 4, 1, 3, 5};
        System.out.println(countInversions(arr, 0, arr.length - 1));
    }
}