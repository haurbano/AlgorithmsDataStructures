public class BinarySearch {
    public int indexOf(int[] arr, int num) {
        int leftBound = 0;
        int rightBound = arr.length - 1;

        while (leftBound <= rightBound) {
            int middleIndex = (leftBound + rightBound) / 2;
            int middleValue = arr[middleIndex];

            if (middleValue == num) {
                return middleIndex;
            } else if (num < middleValue) {
                rightBound = middleIndex - 1;
            } else {
                leftBound = middleIndex + 1;
            }
        }

        return -1;
    }
}
