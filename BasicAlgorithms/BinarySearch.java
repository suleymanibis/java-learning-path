public class BinarySearch {
    public  record Result(boolean found, int targetIndex) { }
    public  Result binarySearch(int[] sortedArray, int target){
        if (sortedArray.length == 0) return new Result(false, -1);

        int right = sortedArray.length - 1;
        int left = 0;
        int mid = left + (right - left) / 2;

        while (left <= right){
            if (sortedArray[mid] == target) return new Result(true, mid);
            else if (sortedArray[mid] > target) right = mid - 1;
            else left = mid + 1;
            mid = left + (right - left) / 2;
        }
        return new Result(false, -1);
    }
}
