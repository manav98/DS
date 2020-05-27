//MERGE SORT
public class merge {

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (right+left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int l = mid - left + 1;
        int r = right - mid;
        int[] L = new int[l];
        for (int z = 0; z < l; z++) {
            L[z] = arr[left + z];
        }
        int[] R = new int[r];
        for (int z = 0; z < r; z++) {
            R[z] = arr[mid + z + 1];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < l && j < r) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else if (R[j] <= L[i]) {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < r) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 90, 4, 43, 34, 12, 120, 1 };
        int size = arr.length;
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}