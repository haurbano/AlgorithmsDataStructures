import java.util.Arrays;

public class MergeSort {
    public void run(int[] arr) {
        int[] sortedArray = sortArray(arr);
        for (int i: sortedArray) {
            System.out.println(i);
        }
    }

    private int[] sortArray(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        // Fill left array
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        // Fill right array
        int k = 0;
        for (int j = mid; j < arr.length; j++) {
            rightArr[k] = arr[j];
            k += 1;
        }

        int[] newLeftArr = sortArray(leftArr);
        int[] newRightArr = sortArray(rightArr);


        return mergeArrays(newLeftArr, newRightArr);
    }

    private int[] mergeArrays(int[] leftArr, int[] rightArr) {
        int arrayResultSize = leftArr.length + rightArr.length;
        int[] arrayResult = new int[arrayResultSize];


        int leftIndex = 0, rightIndex = 0;
        int newArrayIndex = 0;

        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {

            if (leftArr[leftIndex] > rightArr[rightIndex]) {
                arrayResult[newArrayIndex] = leftArr[leftIndex];
                leftIndex++;
            } else {
                arrayResult[newArrayIndex] = rightArr[rightIndex];
                rightIndex++;
            }

            newArrayIndex++;
        }

        while (leftIndex < leftArr.length) {
            arrayResult[newArrayIndex] = leftArr[leftIndex];
            leftIndex++;
            newArrayIndex++;
        }

        while (rightIndex < rightArr.length) {
            arrayResult[newArrayIndex] = rightArr[rightIndex];
            newArrayIndex++;
            rightIndex++;
        }

        return arrayResult;
    }
}
