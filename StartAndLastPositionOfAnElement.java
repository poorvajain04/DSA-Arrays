import java.util.*;
public class StartAndLastPositionOfAnElement {
    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        int target=8;
        System.out.println(Arrays.toString(searchRange(arr,target)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result={-1,-1};
        result[0]=binarySearch(nums,target,true);
        result[1]=binarySearch(nums,target,false);
        return result;
    }
    public static int binarySearch(int[]nums,int target,boolean findstart){
        int start=0;
        int end=nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==nums[mid]){
                ans=mid;
                if(findstart){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            if(target>nums[mid]){
                start=mid+1;
            }
            if(target<nums[mid]){
                end=mid-1;
            }
        }
        return ans;
    }
}

