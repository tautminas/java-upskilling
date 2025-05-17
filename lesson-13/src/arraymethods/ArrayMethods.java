package arraymethods;

public class ArrayMethods {

    public static int[] sortDescending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
        return arr;
    }

    public static int[] sortAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static int[] removeDuplicates(int[] arr) {
        int[] unique = new int[arr.length];
        int newSize = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < newSize; j++) {
                if (arr[i] == unique[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                unique[newSize] = arr[i];
                newSize++;
            }
        }

        int[] result = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            result[i] = unique[i];
        }

        return result;
    }


    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        int[] common = new int[Math.min(arr1.length, arr2.length)];
        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            boolean isInArr2 = false;
            boolean alreadyAdded = false;

            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    isInArr2 = true;
                    break;
                }
            }

            for (int k = 0; k < count; k++) {
                if (common[k] == arr1[i]) {
                    alreadyAdded = true;
                    break;
                }
            }

            if (isInArr2 && !alreadyAdded) {
                common[count] = arr1[i];
                count++;
            }
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = common[i];
        }

        return result;
    }

    public static int[] closestToZero(int[] arr) {
        if (arr.length < 2) return new int[0];

        sortAscending(arr);

        int left = 0;
        int right = arr.length - 1;
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static int[] longestConsecutiveSequence(int[] arr) {
        if (arr.length == 0) return new int[0];

        sortAscending(arr);

        int maxLength = 1;
        int currentLength = 1;
        int start = arr[0];
        int bestStart = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                continue;
            } else if (arr[i] + 1 == arr[i + 1]) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    bestStart = start;
                }
                start = arr[i + 1];
                currentLength = 1;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
            bestStart = start;
        }

        int[] result = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            result[i] = bestStart + i;
        }

        return result;
    }
}
