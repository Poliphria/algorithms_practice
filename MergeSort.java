import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]) {
        int[] mergeData = new int[10];
        int[] temp = new int[mergeData.length];
        populateArray(mergeData);
        System.out.printf("Original Array: %s\n", Arrays.toString(mergeData));
        
        long mergeStart = System.nanoTime();
        mergeSort(mergeData, temp);
        long mergeEnd = System.nanoTime(); 
        long mergeDuration = (mergeEnd - mergeStart) / 1000000; 

        System.out.printf("Duration of merge sort algorithm is: %dms \n", mergeDuration);
        System.out.printf("Here is the sorted array: %s\n", Arrays.toString(mergeData));
    }

    public static void populateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
        }
    }

    public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) return;

        // find the middle of the [sub]array
        int middle = (leftStart + rightEnd) / 2;

        // mergesort the left half of the array
        mergeSort(array, temp, leftStart, middle);
        mergeSort(array, temp, middle + 1, rightEnd);

        // merge the halves together
        merge(array, temp, leftStart, rightEnd);
        
    }

    public static void mergeSort(int[] array, int[] temp) {
        mergeSort(array, temp, 0, array.length - 1);
    }

    public static void merge(int[] array, int[] temp, int leftStart, int rightEnd) {
        // create pointers
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, (leftEnd - left) + 1);
        System.arraycopy(array, right, temp, index, (rightEnd - right) + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);

        System.out.printf("Array length: " + array.length + " Merged back array: %s\n", Arrays.toString(array));
    }
}
