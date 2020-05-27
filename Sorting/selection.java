//SELECTION SORT
class selection
{
    static void swap(int a, int b)
    {
        int tmp = a;
        a = b;
        b = tmp;
    }

    static void sort(int[] arr, int start,int n)
    {
        if(start == n)
        return;
        int minpos = start;
        for(int i=start+1; i<n;i++)
        {
            if(arr[i] < arr[minpos])
                minpos = i;
        }
        //swap(arr[minpos], arr[start]);
        int temp = arr[minpos];
        arr[minpos] = arr[start];
        arr[start] = temp;
        sort(arr, start+1, n);
    }
    public static void main(String[] args) {
        int[] arr = {2,90,4,43,34,12,120,1};
        //int minpos = 0;
        int size = arr.length;
        sort(arr,0,size);
        /* for(int startpos=0; startpos < arr.length; startpos++)
        {
            minpos = startpos;
            for(int j = startpos+1; j < arr.length; j++)
            {
                if(arr[j] < arr[minpos])
                {
                    minpos = j;
                }
            }
            //swap(arr[startpos],arr[minpos]);
            int temp = arr[startpos];
            arr[startpos] = arr[minpos];
            arr[minpos] = temp;
        } */
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}