import java.util.*;
public class quick_sort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String[] starr=line.trim().split("\\s+");
        int[] arr = new int[starr.length];
        for(int i=0;i<starr.length;i++){
            arr[i]=Integer.parseInt(starr[i]);
        }
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        
        sc.close();
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int pivotIndex = partition(arr, low, high);

        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    private  static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
