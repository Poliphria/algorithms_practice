class BinarySearch {
    public static void main(String[] args) {
        int[] testList = { 1, 3, 9, 11, 15, 19, 29 };

        int testValue1 = 25;
        int testValue2 = 15;

        System.out.println(binarySearch(testList, testValue1));
        System.out.println(binarySearch(testList, testValue2));
    }

    public static boolean binarySearch(int[] array, int x, int left, int right) {
        if (left > right) {
            return false;
        }

        int mid = left + ((right - left) / 2);

        if (array[mid] == x) {
            return true;
        } else if (x < array[mid]) {
            right = mid - 1;
            return binarySearch(array, x, left, right);
        } else {
            left = mid + 1;
            return binarySearch(array, x, left, right);
        }
    }

    public static boolean binarySearch(int[] array, int x) {
        return binarySearch(array, x, 0, array.length - 1);
    }

}