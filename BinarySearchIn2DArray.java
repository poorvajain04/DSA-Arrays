import java.util.*;
public class BinarySearchIn2DArray {
    static void main(String[] args) {
        int[][]nums={
                {10,20,30,40},
                {15,25,35,45},
                {28,32,37,41},
                {36,38,42,50}
        };
        System.out.println(Arrays.toString(BinarySearch(nums,37)));
    }
    static int[] BinarySearch(int[][]matrix, int target){
        int row=0;
        int col=matrix.length-1;
        while(row<matrix.length&&col>=0){
            if(matrix[row][col]==target){
                return new int[]{row,col};
            }
            if(matrix[row][col]<target){
                row++;
            }
            else{
                col--;
            }
        }
        return new int[] {-1,-1};
    }
}
