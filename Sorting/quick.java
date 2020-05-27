//QUICK SORT
public class quick {
    static void quickSort(int[] arr, int start, int pivot) {
        if (start < pivot) {
            int seperator = start;
            for (int i = start; i < pivot; i++) {
                if (arr[i] < arr[pivot]) {
                    int temp = arr[i];
                    arr[i] = arr[seperator];
                    arr[seperator] = temp;
                    seperator++;
                }
            }
            int temp = arr[pivot];
            arr[pivot] = arr[seperator];
            arr[seperator] = temp;
            quickSort(arr, start, seperator - 1);
            quickSort(arr, seperator + 1, pivot);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 43, 32, 22, 78, 63, 57, 91, 13 };
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}