//INSERTION SORT
public class insertion
{

    static void swap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    static void insertionSortIterative(int[] arr)
    {
        int size = arr.length;
        for (int start = 1; start < size; start++)
        {
            int itr = start;
            while (itr > 0 && arr[itr] < arr[itr - 1])
            {
                /*
                 * int tmp = arr[itr]; arr[itr] = arr[itr-1]; arr[itr-1] = tmp;
                 */
                swap(arr[itr], arr[itr - 1]);
                itr--;
            }
        }
    }

    static void insertionSortRecursive(int[] arr, int start, int size)
    {
        if (start == size)
            return;
        int itr = start;
        while (itr > 0 && arr[itr] < arr[itr - 1])
        {
            int temp = arr[itr];
            arr[itr] = arr[itr - 1];
            arr[itr - 1] = temp;
            itr--;
        }
        insertionSortRecursive(arr, start + 1, size);
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 90, 4, 43, 34, 12, 120, 1};
        int size = arr.length;
        // insertionSortIterative(arr);
        insertionSortRecursive(arr, 0, size);
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}