public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[]nums={9,8,7,1,3,5,6};
        int target=4;
        System.out.println(search(nums,target));
    }
    public static int search(int[]nums,int target){
        int pivot=peak(nums);
        if(pivot==-1){
            return binarySearch(nums,target,0,nums.length-1);
        }
        if(nums[pivot]==target)return pivot;
        if(nums[pivot]>target){
            return binarySearch(nums,target,0,pivot-1);
        }
        return binarySearch(nums,target,pivot+1,nums.length-1);
    }
    public static int peak(int[]nums){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[mid+1]&&mid<end){
                return mid;
            }
            if(nums[mid]<nums[mid-1]&&mid>start){
                return mid-1;
            }
            if(nums[start]>=nums[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] nums,int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}
