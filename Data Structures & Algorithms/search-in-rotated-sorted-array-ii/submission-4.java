

class Solution {
    public boolean search(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (arr[mid] == target)
                return true;
            if(arr[mid]==arr[i]&&arr[mid]==arr[j]) {
                i++;
                j--;
            }
            else if (arr[mid] < arr[i]) {
                if (target > arr[mid] && target <= arr[j])
                    i = mid + 1;
                else
                    j = mid - 1;
            } else if (arr[mid] >= arr[i]) {
                if (target >= arr[i] && target < arr[mid])
                    j = mid - 1;
                else
                    i = mid + 1;
            } 
        }
        return false;
    }
}    
