import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingAlg {

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;

            T[] left = Arrays.copyOfRange(arr, 0, mid);
            T[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] arr, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array to be sorted: ");
        int size = scanner.nextInt();
        Integer[] arr = generateRandomArray(size);

        System.out.println("\nUnsorted Array:");
        System.out.println(Arrays.toString(arr));

        Integer[] arrayBubble = arr.clone();
        Integer[] arrayMerge = arr.clone();

        System.out.println("\nSorting using BubbleSort!");
        bubbleSort(arrayBubble);
        System.out.println("Sorted Array from Bubble Sort");
        System.out.println(Arrays.toString(arrayBubble));

        System.out.println("\nSorting using MergeSort!");
        mergeSort(arrayMerge);
        System.out.println("Sorted Array from Merge Sort");
        System.out.println(Arrays.toString(arrayMerge));

        scanner.close();
    }
}
