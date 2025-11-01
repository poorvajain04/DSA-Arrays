public class RotatedBinarySearchInArrayWithDuplicateValues {
    static void main(String[] args){
        int[] arr={2,9,2,2,2};
        int target=9;
        System.out.println(search(arr,target));
    }
    static int search(int[]arr,int target){
        int pivot=PivotinDuplicateValues(arr);
        if(pivot==-1){
            return binarySearch(arr,target,0,arr.length-1);
        }
        if(arr[pivot]==target){
            return pivot;
        }
        int left=binarySearch(arr,target,0,pivot-1);
        if(left!=-1){
            return left;
        }
        return binarySearch(arr,target,pivot+1,arr.length-1);
    }
    static int PivotinDuplicateValues(int[]arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid<end &&arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[start]==arr[mid]&&arr[mid]==arr[end]){
                if(arr[start]<arr[start+1]){
                    start++;
                }
                if(arr[end]<arr[end-1]){
                    end--;
                }
            }
            else if(arr[start]<arr[mid]||(arr[mid]>arr[end] && arr[start]==arr[mid])){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
    static int binarySearch(int[]arr,int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}
