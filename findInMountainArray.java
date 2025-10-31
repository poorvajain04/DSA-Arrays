public class findInMountainArray {
    public static void main(String[] args) {
        int[]mountainArr={4,5,6,7,8,9,0,1,2,3};
        int target=8;
        System.out.println(findIndexInMountainArray(mountainArr,target));
    }
    public static int findIndexInMountainArray(int[]mountainArr,int target){
        int n=mountainArr.length;
        int peak=findPeak(mountainArr,n);
        int left=binarySearch(mountainArr,target,0,peak,true);
        if(left!=-1){
            return left;
        }
        return binarySearch(mountainArr,target,peak+1,n-1,false);
    }
    public static int findPeak(int[]mountainArr,int n){
        int start=0;
        int end=n-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(mountainArr[mid]>mountainArr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
    public static int binarySearch(int[]mountainArr,int target,int start,int end,boolean ascending){
        while(start<=end){
            int mid=start+(end-start)/2;
            int midVal=mountainArr[mid];
            if(midVal==target){
                return mid;
            }
            if(ascending){
                if(midVal<target){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            else{
                if(midVal<target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return -1;

    }
}
